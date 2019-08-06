package com.ogoma.vue_starter.vue_starter.controllers;

import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import com.ogoma.vue_starter.vue_starter.services.UserService;
import com.ogoma.vue_starter.vue_starter.utils.ErrorConverter;
import com.ogoma.vue_starter.vue_starter.validators.ForgotPasswordRequestValidator;
import com.ogoma.vue_starter.vue_starter.validators.UserRegistrationModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRegistrationModelValidator userRegistrationModelValidator;

    @Autowired
    private ForgotPasswordRequestValidator forgotPasswordRequestValidator;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "auth/login";
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationModel userRegistrationModel,
                                          BindingResult bindingResult) throws MessagingException {
        userRegistrationModelValidator.validate(userRegistrationModel, bindingResult);
        if (!bindingResult.hasErrors()) {
            User user = this.userService.register(userRegistrationModel);
            return ResponseEntity.ok(user);
        }
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(bindingResult);
        return ResponseEntity.badRequest().body(errors);
    }

    @RequestMapping(value = "forgot-password", method = RequestMethod.POST)
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest,
                                            BindingResult bindingResult) {
        forgotPasswordRequestValidator.validate(forgotPasswordRequest, bindingResult);
        if (!bindingResult.hasErrors()) {
            this.userService.handleForgotPasswordRequest(forgotPasswordRequest);
        }
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(bindingResult);
        return ResponseEntity.badRequest().body(errors);
    }
}
