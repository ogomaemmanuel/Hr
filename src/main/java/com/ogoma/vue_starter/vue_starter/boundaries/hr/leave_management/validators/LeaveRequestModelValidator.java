package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.validators;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class LeaveRequestModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LeaveRequestModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.required", "Start date is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfDays", "field.required", "Enter leave days");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inPlaceId", "field.required", "Select in place employee");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveTypeId", "field.required", "Select leave type");
    }
}
