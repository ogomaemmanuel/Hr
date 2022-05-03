package com.ogoma.hr_core.boundaries.access_control.services;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.models.FamilyMemberModel;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.EmergencyContactModel;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.hr_core.boundaries.user_profile.models.PasswordUpdateRequest;
import com.ogoma.hr_core.models.ResponseModel;
import com.ogoma.hr_core.models.requests.ForgotPasswordRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import com.ogoma.hr_core.models.requests.PasswordResetRequest;
import com.ogoma.hr_core.models.requests.UserRegistrationModel;
import org.springframework.data.domain.Page;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
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

    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);

    Map<String,String> getUserDetails(Long id);

    String updateEmergencyContact(EmergencyContactModel model);

    List<Map<String,String>> getEmergencyContacts(Long userId);

    String saveFamilyMembers(FamilyMemberModel model);

    String updateFamilyMember(FamilyMemberModel.Member member);

    ByteArrayOutputStream report() throws Exception;
}
