package com.ogoma.hr_core.validators;

import com.ogoma.hr_core.models.requests.PasswordResetRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class PasswordResetRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PasswordResetRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //TODO check if token belong to user
        //TODO check if password is strong
        PasswordResetRequest passwordResetRequest = (PasswordResetRequest) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Password confirmation is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "token", "field.required", "Token is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "field.required", "User id is required");
        if (!(passwordResetRequest.getPassword() != null && passwordResetRequest.getPassword().equals(passwordResetRequest.getConfirmPassword()))) {
            errors.rejectValue("password", "field.mismatch", "Passwords do not match");
        }
    }
}
