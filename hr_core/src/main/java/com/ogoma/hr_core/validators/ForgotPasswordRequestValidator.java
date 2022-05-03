package com.ogoma.hr_core.validators;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.models.requests.ForgotPasswordRequest;
import com.ogoma.hr_core.boundaries.access_control.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ForgotPasswordRequestValidator implements Validator {
    private final UserService userService;

    public ForgotPasswordRequestValidator(UserService userService) {
        this.userService = userService;
    }

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
                errors.rejectValue("email", "field.missing", "User with this email does not exist");
            }
        }

    }
}
