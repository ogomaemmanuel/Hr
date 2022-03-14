package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmergencyContactModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.repositories.FamilyRelationshipRepository;
import com.ogoma.vue_starter.vue_starter.repositories.MaritalStatusRepository;
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
    private MaritalStatusRepository maritalStatusRepository;
    private FamilyRelationshipRepository relationshipRepository;
    @Autowired
    public UsersController(UserService userService,MaritalStatusRepository maritalStatusRepository,FamilyRelationshipRepository relationshipRepository) {
        this.userService = userService;
        this.maritalStatusRepository = maritalStatusRepository;
        this.relationshipRepository = relationshipRepository;
    }

    //    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    @GetMapping("/api/users")
    public ResponseEntity<?> getUsers(PagedDataRequest pagedDataRequest) {
        Page<User> userList = this.userService.getAll(pagedDataRequest);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("api/users/marital-status")
    public ResponseEntity<?> getMaritalStatus(){
        return ResponseEntity.ok(maritalStatusRepository.findAll());
    }

    @GetMapping("api/users/family-relationships")
    public ResponseEntity<?> getFamilyRelationships(){
        return ResponseEntity.ok(relationshipRepository.findAll());
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

}
