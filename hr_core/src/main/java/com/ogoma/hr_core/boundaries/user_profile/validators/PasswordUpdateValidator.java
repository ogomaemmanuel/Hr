package com.ogoma.hr_core.boundaries.user_profile.validators;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.hr_core.boundaries.user_profile.models.PasswordUpdateRequest;
import com.ogoma.hr_core.utils.SecurityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordUpdateValidator implements Validator {
    private final UsersRepository usersRepository;

    public PasswordUpdateValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(PasswordUpdateRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordUpdateRequest passwordUpdateRequest = (PasswordUpdateRequest) target;
        CustomUserDetails customUserDetails = SecurityUtils.getCurrentUserDetails();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "field.required", "New password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "field.required", "Old password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmationPassword", "field.required", "Password confirmation is required");
        if (null != passwordUpdateRequest.getOldPassword()) {
            User user = this.usersRepository.findById(customUserDetails.getId()).orElse(null);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Boolean oldPasswordMatch = bCryptPasswordEncoder.matches(passwordUpdateRequest.getOldPassword(), user.getPassword());
            if (!oldPasswordMatch) {
                errors.rejectValue("oldPassword", "password.mismatch", "Old password is not correct");
            }
        }
        if (null != passwordUpdateRequest.getNewPassword()) {
            if (!passwordUpdateRequest.getNewPassword().equals(passwordUpdateRequest.getConfirmationPassword())) {
                errors.rejectValue("confirmationPassword", "password.mismatch", "Confirmation password does not match");
            }
        }
    }
}
