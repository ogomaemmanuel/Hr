package com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee_;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users"
        , indexes = {
        @Index(name = "identity_no_index", columnList = User_.IDENTITY_NO, unique = true),
        @Index(name = "email_index", columnList = User_.EMAIL, unique = true),
        @Index(name = "last_name_index", columnList = User_.LAST_NAME),
        @Index(name = "first_name_index", columnList = User_.FIRST_NAME),
        @Index(name = "phone_index", columnList = User_.PHONE, unique = true)
}
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    public enum UserType{
        Admin,
        Client,
        Employee,
        User,
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email name is required")
    private String email;
    @NotBlank(message = "Phone is required")
    private String phone;
    private Date dateOfBirth;
    private String identityNo;
    private String city;
    private String postalAddress;
    private Long maritalStatusId;
    @Transient
    @JsonProperty
    private String fullName;
    @OneToOne(mappedBy = Employee_.USER, fetch = FetchType.LAZY)
    private Employee employee;
    @JsonIgnore
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedOn;
    @JsonIgnore
    @OneToMany(mappedBy = UserRole_.USER, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;
    @OneToMany(mappedBy = PasswordReset_.USER, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties(PasswordReset_.USER)
    private Set<PasswordReset> passwordResetList;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Long getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(Long maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonIgnore
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }


    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonIgnore
    public Set<PasswordReset> getPasswordResetList() {
        return passwordResetList;
    }

    public void setPasswordResetList(Set<PasswordReset> passwordResetList) {
        this.passwordResetList = passwordResetList;
    }

    public void addStaff(Employee newEmployee) {
        if (newEmployee == null) {
            if (this.employee != null) {
                this.employee.setUser(null);
            }
        } else {
            newEmployee.setUser(this);
        }
        this.employee = newEmployee;
    }

    @PostLoad
    public void setUserFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    @PrePersist
    public void beforePersist() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (this.getPassword() != null) {
            encodePassword(this.password);
        }
    }

    public void updatePassword(String password) {
        encodePassword(password);
    }

    private void encodePassword(String password) {
        if (password != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            this.password = bCryptPasswordEncoder.encode(password);
        }
    }
}
