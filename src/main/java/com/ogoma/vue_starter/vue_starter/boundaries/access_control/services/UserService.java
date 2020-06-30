package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PasswordResetRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import org.springframework.data.domain.Page;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserByEmail(String email);

    User register(UserRegistrationModel userRegistrationModel);

    User create(EmployeeCreateModel.BasicInfo basicUserInfo);

    Optional<User> getUserById(Long id);

    Page<User> getAll(PagedDataRequest pagedDataRequest);

    Optional<User> updateUser(Long userId, EmployeeCreateModel.BasicInfo basicUserInfo);


    void handleForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest);

    ResponseModel resetUserPassword(PasswordResetRequest passwordResetRequest);

    ByteArrayOutputStream report() throws Exception;
}
