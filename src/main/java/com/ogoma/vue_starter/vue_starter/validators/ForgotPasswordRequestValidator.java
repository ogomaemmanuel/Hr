package com.ogoma.vue_starter.vue_starter.validators;

import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ForgotPasswordRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ForgotPasswordRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ForgotPasswordRequest forgotPasswordRequest = (ForgotPasswordRequest) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Email is required");
    }
}
