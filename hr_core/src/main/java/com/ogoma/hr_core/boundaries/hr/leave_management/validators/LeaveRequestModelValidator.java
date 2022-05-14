package com.ogoma.hr_core.boundaries.hr.leave_management.validators;

import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveType;
import com.ogoma.hr_core.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.hr_core.boundaries.hr.leave_management.repositories.LeaveRequestRepository;
import com.ogoma.hr_core.boundaries.hr.leave_management.repositories.LeaveTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Timestamp;
import java.time.LocalDate;

@Component
public class LeaveRequestModelValidator implements Validator {
    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveTypesRepository leaveTypesRepository;

    @Autowired
    public LeaveRequestModelValidator(LeaveRequestRepository leaveRequestRepository, LeaveTypesRepository leaveTypesRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveTypesRepository = leaveTypesRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LeaveRequestModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LeaveRequestModel leaveRequestModel = (LeaveRequestModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.required", "Start date is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "field.required", "End date is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfDays", "field.required", "Enter leave days");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inPlaceId", "field.required", "Select in place employee");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveTypeId", "field.required", "Select leave type");
        if (leaveRequestModel.getStartDate() != null) {
            LocalDate serverLocalDate = LocalDate.now();
            Timestamp serverTimestamp = Timestamp.valueOf(serverLocalDate.atStartOfDay());
            Timestamp requestTimeStamp = new Timestamp(leaveRequestModel.getStartDate().getTime());
            if (requestTimeStamp.compareTo(serverTimestamp) != 1) {
                errors.rejectValue("startDate", "field.invalid", "Start date must be in the future");
            }
        }
        if (leaveRequestModel.getLeaveTypeId() != null) {
            Long leaveBalance =
                    leaveRequestRepository.currentUserLeaveBalanceByLeaveTypeId(leaveRequestModel.getLeaveTypeId());
            if (leaveBalance != null && leaveBalance <= 0l) {
                errors.rejectValue("leaveTypeId", "field.invalid", "Your have leave balance is zero");
            }
        }
        if (leaveRequestModel.getLeaveTypeId() != null && leaveRequestModel.getNumberOfDays() != null) {
            LeaveType leaveType = leaveTypesRepository.findById(leaveRequestModel.getLeaveTypeId()).orElse(null);
            if (leaveType.getNumberOfDays() < leaveRequestModel.getNumberOfDays()) {
                errors.rejectValue("numberOfDays", "field.invalid", "Leave days more than allowed");
            }
        }
    }
}
