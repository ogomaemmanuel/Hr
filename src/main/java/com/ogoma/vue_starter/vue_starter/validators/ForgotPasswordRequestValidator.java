package com.ogoma.vue_starter.vue_starter.validators;

import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ForgotPasswordRequestValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ForgotPasswordRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Todo check if email is registered
        ForgotPasswordRequest forgotPasswordRequest = (ForgotPasswordRequest) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Email is required");
        if (forgotPasswordRequest.getEmail() != null) {
            User user = userService.getUserByEmail(forgotPasswordRequest.getEmail());
            if (user == null) {
                errors.rejectValue("email", "field.missing", "User with this email daoes not exist");
            }
        }

    }
}
