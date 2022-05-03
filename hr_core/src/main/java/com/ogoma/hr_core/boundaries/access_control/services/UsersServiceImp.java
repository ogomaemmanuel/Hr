package com.ogoma.hr_core.boundaries.access_control.services;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import com.ogoma.hr_core.boundaries.access_control.entities.EmergencyContact;
import com.ogoma.hr_core.boundaries.access_control.entities.PasswordReset;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.models.FamilyMemberModel;
import com.ogoma.hr_core.boundaries.access_control.repositories.EmergencyContactRepository;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.EmergencyContactModel;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.hr_core.boundaries.user_profile.models.PasswordUpdateRequest;
import com.ogoma.hr_core.events.auth.PasswordResetEvent;
import com.ogoma.hr_core.events.auth.UserRegistrationEvent;
import com.ogoma.hr_core.models.ResponseModel;
import com.ogoma.hr_core.models.requests.ForgotPasswordRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import com.ogoma.hr_core.models.requests.PasswordResetRequest;
import com.ogoma.hr_core.models.requests.UserRegistrationModel;
import com.ogoma.hr_core.boundaries.access_control.repositories.PasswordResetRepository;
import com.ogoma.hr_core.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.hr_core.utils.RandomStringGenerator;
import com.ogoma.hr_core.utils.SecurityUtils;
import com.ogoma.hr_core.utils.reports.ReportGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.io.ByteArrayOutputStream;
import java.util.*;

@Service

public class UsersServiceImp implements UserService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UsersRepository usersRepository;
    private final EmergencyContactRepository contactRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordResetRepository passwordResetRepository;
    private final ReportGenerator reportGenerator;
    private final FamilyMemberService memberService;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder,
                           EmergencyContactRepository contactRepository,
                           PasswordResetRepository passwordResetRepository,
                           ReportGenerator reportGenerator,
                           ApplicationEventPublisher applicationEventPublisher,
                           FamilyMemberService memberService) {
        this.usersRepository = usersRepository;
        this.passwordResetRepository = passwordResetRepository;
        this.reportGenerator = reportGenerator;
        this.passwordEncoder = passwordEncoder;
        this.contactRepository = contactRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.memberService = memberService;
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
        String password = RandomStringGenerator.randomStringGenerator(8, true);
        user.setPassword(password);
        this.usersRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = this.usersRepository.findById(id);
        return user;
    }

    @Override
    public Page<User> getAll(PagedDataRequest pagedDataRequest) {
        Page<User> users = this.usersRepository.findAll(
                new Specification<User>() {
                    @Override
                    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        if(Long.class!=criteriaQuery.getResultType()){
                            //root.fetch(User_.employee, JoinType.LEFT);
                        }
                        return criteriaBuilder.conjunction();
                    }
                },
                pagedDataRequest.toPageable());
        return users;
    }

    @Override
    public Optional<User> updateUser(Long userId, EmployeeCreateModel.BasicInfo basicUserInfo) {
        Optional<User> user = this.usersRepository.findById(userId);
        user.ifPresent(u -> {
            BeanUtils.copyProperties(basicUserInfo, u);
            this.usersRepository.save(u);
        });
        return user;
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
    public void updatePassword(PasswordUpdateRequest passwordUpdateRequest) {
        CustomUserDetails customUserDetails = SecurityUtils.getCurrentUserDetails();
        User user = this.usersRepository.findById(customUserDetails.getId()).orElse(null);
        user.updatePassword(passwordUpdateRequest.getNewPassword());
        this.usersRepository.save(user);
    }

    @Override
    public Map<String,String> getUserDetails(Long id){
        return usersRepository.findUserDetails(id);
    }

    @Override
    public ByteArrayOutputStream report() throws Exception {
        List<User> users = this.usersRepository.findAll();
        return reportGenerator.generatePdfReport("reports/users.jasper", null, users);
    }

    @Override
    public String updateEmergencyContact(EmergencyContactModel model){
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        EmergencyContact em = contactRepository.findByUserId(model.getUserId());

        if(null != em && model.getId() == null)
            return "contact exists";
        else if(null == em) {
            em = new EmergencyContact();
            em.setCreatedAt(new Date());
            em.setCreatedBy(userId);

        }

        em.setPrimaryName(model.getPrimaryName());
        em.setPrimaryRelationship(model.getPrimaryRelationship());
        em.setPrimaryPhoneOne(model.getPrimaryPhoneOne());
        em.setPrimaryPhoneTwo(model.getPrimaryPhoneTwo());
        em.setSecondaryName(model.getSecondaryName());
        em.setSecondaryRelationship(model.getSecondaryRelationship());
        em.setSecondaryPhoneOne(model.getSecondaryPhoneOne());
        em.setSecondaryPhoneTwo(model.getSecondaryPhoneTwo());
        em.setUserId(model.getUserId());
        em.setUpdatedAt(new Date());
        em.setUpdatedBy(userId);

        contactRepository.save(em);
        return "contact updated";
    }

    public List<Map<String,String>> getEmergencyContacts(Long userId){
        return contactRepository.findAllContactsByUserId(userId);
    }

    @Override
    public String saveFamilyMembers(FamilyMemberModel model){
        return memberService.addFamilyMembers(model);
    }

    @Override
    public String updateFamilyMember(FamilyMemberModel.Member member){
        return memberService.updateMember(member);
    }
}
