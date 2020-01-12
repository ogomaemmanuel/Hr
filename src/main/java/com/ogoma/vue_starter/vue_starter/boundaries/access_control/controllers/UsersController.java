package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<User> userList = this.userService.getAll();
        return ResponseEntity.ok(userList);
    }
    @RequestMapping(value="api/users/reports",method= RequestMethod.GET)
    public ResponseEntity<InputStreamResource> report() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = userService.report();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=fundraiserReports.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }


}
