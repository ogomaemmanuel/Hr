package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PasswordResetRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface UserService {

    User getUserByEmail(String email);

    User register(UserRegistrationModel userRegistrationModel);

    List<User> getAll();

    void handleForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest);

    ResponseModel resetUserPassword(PasswordResetRequest passwordResetRequest);

    ByteArrayOutputStream report() throws Exception;
}
