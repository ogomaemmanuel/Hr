package com.ogoma.vue_starter.vue_starter.validators;

import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UserRegistrationModelValidator implements Validator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationModel userRegistrationModel = (UserRegistrationModel)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","field.required","Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","field.required","Phone number is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","field.required","Password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","field.required","First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","field.required","Last name is required");
        if(userRegistrationModel.getPassword()!=null){
           if(!userRegistrationModel.getPassword().equals(userRegistrationModel.getConfirmPassword())){
               errors.rejectValue("password","field.mismatch","Password and confirm password do not match");
            }
        }
        if(!(userRegistrationModel.getEmail()!=null && userRegistrationModel.getEmail().matches(EMAIL_PATTERN))){
            errors.rejectValue("email","pattern.mismatch","Enter a valid email address");
        }
    }
}
