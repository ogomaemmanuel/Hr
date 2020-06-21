package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeContactAddress;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeQuery;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.controllers.AuthController;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.RandomStringGenerator;
import com.ogoma.vue_starter.vue_starter.utils.mail.EmailModel;
import com.ogoma.vue_starter.vue_starter.utils.mail.MailSender;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class EmployeesService {
    private final EmployeeRepository employeeRepository;
    private final MailSender mailSender;

    public EmployeesService(EmployeeRepository employeeRepository, MailSender mailSender) {
        this.mailSender = mailSender;
        this.employeeRepository = employeeRepository;
    }

    public Page<EmployeeQuery> getEmployees(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<EmployeeQuery> employees = this.employeeRepository.getAllEmployees(pageable);
        return employees;
    }

    public Employee createEmployee(EmployeeCreateModel employeeCreateModel) {
        User user = new User();
        Employee employee = new Employee();
        Set<EmployeeContactAddress> employeeContactAddresses = new HashSet<>();
        employeeCreateModel.getContactAddresses().forEach(add -> {
            EmployeeContactAddress employeeContactAddress = new EmployeeContactAddress();
            BeanUtils.copyProperties(add, employeeContactAddress);
            employeeContactAddresses.add(employeeContactAddress);
        });
        BeanUtils.copyProperties(employeeCreateModel.getBasicInfo(), user);
        BeanUtils.copyProperties(employeeCreateModel.getEmployementDetail(), employee);
        employee.setEmployeeContactAddresses(employeeContactAddresses);
        String userPassword = RandomStringGenerator.randomStringGenerator(8, true);
        user.setPassword(userPassword);
        user.addStaff(employee);
        employee.setUser(user);
        this.employeeRepository.save(employee);
        sendRegistrationEmail(employeeCreateModel, userPassword);
        return employee;
    }


    private void sendRegistrationEmail(EmployeeCreateModel employeeCreateModel, String password) {
        Map<String, Object> emailTemplateVariables = new HashMap<>();
        emailTemplateVariables.put("employeeDetail", employeeCreateModel);
        emailTemplateVariables.put("password", password);
        EmailModel emailModel = new EmailModel();
        emailModel.setSubject("Employee Registration");
        emailModel.setHtml(true);
        emailModel.setTo(employeeCreateModel.getBasicInfo().getEmail());
        emailModel.setTemplateVariable(emailTemplateVariables);
        emailModel.setTemplatePath("/employee_registration_successful");
        UriComponentsBuilder base = ServletUriComponentsBuilder.fromCurrentContextPath().path("/");
        String url = base.build().toUriString();
        emailTemplateVariables.put("link", url);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mailSender.sendMail(emailModel);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
