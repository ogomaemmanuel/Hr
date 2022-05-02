package com.ogoma.vue_starter.vue_starter.boundaries.user_profile;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmergencyContactModel;
import com.ogoma.vue_starter.vue_starter.boundaries.user_profile.models.PasswordUpdateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.user_profile.validators.PasswordUpdateValidator;
import com.ogoma.vue_starter.vue_starter.utils.ErrorConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserProfileController {
    private final UserService userService;
    private final PasswordUpdateValidator passwordUpdateValidator;

    public UserProfileController(UserService userService, PasswordUpdateValidator passwordUpdateValidator) {
        this.userService = userService;
        this.passwordUpdateValidator = passwordUpdateValidator;
    }

    @RequestMapping(value = "api/profile/update-password", method = RequestMethod.POST)
    public ResponseEntity<?> updatePassword(@RequestBody PasswordUpdateRequest passwordUpdateRequest,
                                            BindingResult bindingResult) {
        this.passwordUpdateValidator.validate(passwordUpdateRequest, bindingResult);
        if (!bindingResult.hasErrors()) {
            this.userService.updatePassword(passwordUpdateRequest);
            return ResponseEntity.ok("Password successfully updated");
        }
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(bindingResult);
        return ResponseEntity.badRequest().body(errors);
    }

    @RequestMapping(value = "api/profile/update-profile-photo", method = RequestMethod.POST)
    public ResponseEntity<?> updateProfilePhoto() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("api/emergency-contacts/{userId}")
    public ResponseEntity<?> getEmergencyContact(@PathVariable Long userId){
        List<Map<String,String>> contacts = userService.getEmergencyContacts(userId);
        if(contacts.isEmpty())
            return ResponseEntity.ok("");

        return ResponseEntity.ok(contacts.get(0));
    }

    @PostMapping(value = "api/update-emergency-contact")
    public ResponseEntity<?> updateContact(@RequestBody @Valid EmergencyContactModel model){
        Map<String, String> resp = new HashMap<>();
        String message = userService.updateEmergencyContact(model);

        if("contact updated".equalsIgnoreCase(message)){
            resp.put("msg", "Emergency contact updated successfully");
            resp.put("status", "00");
        }else if("contact exists".equalsIgnoreCase(message)){
            resp.put("msg", "This contact already exists");
            resp.put("status", "01");
        }

        return ResponseEntity.ok(resp);
    }

    @GetMapping(value = "api/profile/details/{id}")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDetails(id));
    }
}
