package com.ogoma.vue_starter.vue_starter.boundaries.user_profile;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import com.ogoma.vue_starter.vue_starter.boundaries.user_profile.models.PasswordUpdateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.user_profile.validators.PasswordUpdateValidator;
import com.ogoma.vue_starter.vue_starter.utils.ErrorConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
}
