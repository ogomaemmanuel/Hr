package com.ogoma.vue_starter.vue_starter.services;

import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.models.UserRegistrationModel;

import javax.mail.MessagingException;

public interface UserService {

    User getUserByEmail(String email);

    User register(UserRegistrationModel userRegistrationModel) ;
}
