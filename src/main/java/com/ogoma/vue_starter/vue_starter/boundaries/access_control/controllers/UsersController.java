package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmergencyContactModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UsersController {
    private UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    @GetMapping("/api/users")
    public ResponseEntity<?> getUsers(PagedDataRequest pagedDataRequest) {
        Page<User> userList = this.userService.getAll(pagedDataRequest);
        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = this.userService.getUserById(id);
        return ResponseEntity.of(user);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody EmployeeCreateModel.BasicInfo basicInfo) {
        User user = this.userService.create(basicInfo);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody EmployeeCreateModel.BasicInfo basicInfo) {
        Optional<User> user = this.userService.updateUser(id, basicInfo);
        return ResponseEntity.of(user);
    }

    @RequestMapping(value = "api/users/reports", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> report() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = userService.report();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=fundraiserReports.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }

    @GetMapping("api/emergency-contacts/{userId}")
    public ResponseEntity<?> getEmergencyContact(@PathVariable Long userId){
        List<Map<String,String>> contacts = userService.getEmergencyContacts(userId);
        if(contacts.isEmpty())
        return ResponseEntity.ok(contacts);

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

}
