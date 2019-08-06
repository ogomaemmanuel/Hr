package com.ogoma.vue_starter.vue_starter.services;

import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;

public interface UserService {

    User getUserByEmail(String email);

    User register(UserRegistrationModel userRegistrationModel);

    void handleForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest);
}
