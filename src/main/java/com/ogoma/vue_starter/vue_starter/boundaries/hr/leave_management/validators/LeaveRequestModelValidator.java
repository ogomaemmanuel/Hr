package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.validators;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LeaveRequestModelValidator implements Validator {

    private final LeaveRequestRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestModelValidator(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LeaveRequestModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LeaveRequestModel leaveRequestModel = (LeaveRequestModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.required", "Start date is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfDays", "field.required", "Enter leave days");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inPlaceId", "field.required", "Select in place employee");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveTypeId", "field.required", "Select leave type");
        if (leaveRequestModel.getLeaveTypeId() != null) {
         Long leaveBalance=
                 leaveRequestRepository.currentUserLeaveBalanceByLeaveTypeId(leaveRequestModel.getLeaveTypeId());
         if(leaveBalance<=0l){
             errors.rejectValue("leaveTypeId","field.invalid","Your have leave balance is zero");
         }
        }
    }
}
