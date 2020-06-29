package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.PasswordReset;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.events.auth.PasswordResetEvent;
import com.ogoma.vue_starter.vue_starter.events.auth.UserRegistrationEvent;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.ForgotPasswordRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PasswordResetRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.UserRegistrationModel;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PasswordResetRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.vue_starter.vue_starter.utils.RandomStringGenerator;
import com.ogoma.vue_starter.vue_starter.utils.reports.ReportGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class UsersServiceImp implements UserService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private PasswordResetRepository passwordResetRepository;
    private ReportGenerator reportGenerator;


    @Autowired
    public UsersServiceImp(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder,
                           PasswordResetRepository passwordResetRepository,
                           ReportGenerator reportGenerator
    ) {
        this.usersRepository = usersRepository;
        this.passwordResetRepository = passwordResetRepository;
        this.reportGenerator = reportGenerator;
        this.passwordEncoder = passwordEncoder;

    }

    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    public User register(UserRegistrationModel userRegistrationModel) {
        User user = new User();
        BeanUtils.copyProperties(userRegistrationModel, user);
        User savedDetails = this.usersRepository.save(user);
        String registrationToken = RandomStringGenerator.randomStringGenerator(32, false);
        PasswordReset passwordReset = new PasswordReset(
                registrationToken,
                savedDetails);
        passwordResetRepository.save(passwordReset);
        Map<String, Object> registrationData = new HashMap<>();
        registrationData.put("user", savedDetails);
        registrationData.put("token", passwordReset);
        UserRegistrationEvent userRegistrationEvent = new UserRegistrationEvent(this, registrationData);
        applicationEventPublisher.publishEvent(userRegistrationEvent);
        return savedDetails;
    }

    @Override
    public User create(EmployeeCreateModel.BasicInfo basicUserInfo) {
        User user = new User();
        BeanUtils.copyProperties(basicUserInfo, user);
        this.usersRepository.save(user);
        return user;
    }

    @Override
    public Page<User> getAll(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<User> users = this.usersRepository.findAll(pageRequest);
        return users;
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

    @Override
    public ByteArrayOutputStream report() throws Exception {
        List<User> users = this.usersRepository.findAll();
        return reportGenerator.generatePdfReport("reports/users.jasper", null, users);
    }
}
