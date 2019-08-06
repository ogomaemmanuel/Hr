package com.ogoma.vue_starter.vue_starter.services;

import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.events.auth.UserRegistrationEvent;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import com.ogoma.vue_starter.vue_starter.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UserService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UsersServiceImp(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder
    ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    public User register(UserRegistrationModel userRegistrationModel) {
        User user = new User();
        BeanUtils.copyProperties(userRegistrationModel, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedDetails = this.usersRepository.save(user);
        UserRegistrationEvent userRegistrationEvent = new UserRegistrationEvent(this, savedDetails);
        applicationEventPublisher.publishEvent(userRegistrationEvent);
        return savedDetails;
    }

    @Override
    public void handleForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest) {

    }
}
