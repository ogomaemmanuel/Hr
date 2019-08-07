package com.ogoma.vue_starter.vue_starter.services;

import com.ogoma.vue_starter.vue_starter.entities.PasswordReset;
import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.events.auth.PasswordResetEvent;
import com.ogoma.vue_starter.vue_starter.events.auth.UserRegistrationEvent;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PasswordResetRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import com.ogoma.vue_starter.vue_starter.repository.PasswordResetRepository;
import com.ogoma.vue_starter.vue_starter.repository.UsersRepository;
import com.ogoma.vue_starter.vue_starter.utils.RandomStringGenerator;
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
    private PasswordResetRepository passwordResetRepository;


    @Autowired
    public UsersServiceImp(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder,
                           PasswordResetRepository passwordResetRepository
    ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordResetRepository = passwordResetRepository;

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
        //ToDo handle null for non existing user

        User user = this.getUserByEmail(forgotPasswordRequest.getEmail());
        String token = RandomStringGenerator.randomStringGenerator(32, false);
        PasswordReset myToken = new PasswordReset(token, user);
        String url;
        PasswordReset passwordReset = passwordResetRepository.save(myToken);
        PasswordResetEvent passwordResetEvent = new PasswordResetEvent(this, passwordReset);
        applicationEventPublisher.publishEvent(passwordResetEvent);
    }

    @Override
    public ResponseModel resetUserPassword(PasswordResetRequest passwordResetRequest) {
        //TODO return response and handle null
        ResponseModel responseModel = new ResponseModel();
        PasswordReset passwordReset = this.passwordResetRepository.findByToken(passwordResetRequest.getToken());
        User user = passwordReset.getUser();
        if (user == null) {
            responseModel.setStatus("01");
            responseModel.setMessage("Invalid token");
            responseModel.setState("danger");
            return responseModel;
        }
        if (user.getId().compareTo(passwordResetRequest.getUserId()) == 0) {
            user.setPassword(passwordEncoder.encode(passwordResetRequest.getPassword()));
            passwordReset.setUsed(true);
            passwordResetRepository.save(passwordReset);
            responseModel.setStatus("00");
            responseModel.setMessage("Password reset successful");
            responseModel.setState("success");
            return responseModel;
        }
        responseModel.setStatus("01");
        responseModel.setMessage("Invalid token");
        responseModel.setState("success");
        return responseModel;
    }
}
