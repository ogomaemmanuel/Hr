package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EmployeeCreateModel {
    @Valid
    @NotNull
    private BasicInfo basicInfo;
    @Valid
    @NotNull
    private Set<ContactAddress> contactAddresses;
    @Valid
    @NotNull
    private EmployementDetail employementDetail;

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Set<ContactAddress> getContactAddresses() {
        return contactAddresses;
    }

    public void setContactAddresses(Set<ContactAddress> contactAddresses) {
        this.contactAddresses = contactAddresses;
    }

    public EmployementDetail getEmployementDetail() {
        return employementDetail;
    }

    public void setEmployementDetail(EmployementDetail employementDetail) {
        this.employementDetail = employementDetail;
    }

    public static class BasicInfo {
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        @NotBlank
        private String phone;
        @NotBlank
        private String email;
        @NotBlank
        private String identityNo;
        @NotBlank
        private String city;
        private String zipCode;
        private String postalAddress;
        private Long maritalStatusId;
        @NotNull
        @Min(value = 0)
        private BigDecimal salary;
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private Date dateOfBirth;
        private String avatarUrl;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
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

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }

    public static class ContactAddress {
        @NotBlank
        private String phoneNumber;
        @NotBlank
        private String name;
        @NotBlank
        private String relationshipId;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRelationshipId() {
            return relationshipId;
        }

        public void setRelationshipId(String relationshipId) {
            this.relationshipId = relationshipId;
        }
    }

    public static class EmployementDetail {
        @NotBlank
        private Long departmentId;
        @NotBlank
        private Long designationId;
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private Date joiningDate;

        private Long shiftId;
        @NotNull
        @Min(value = 0)
        private BigDecimal salaryAmount;
        private Long supervisorId;
        @JsonProperty(value = "kraPin")
        private String kraPinNumber;
        @JsonProperty(value = "nhifNo")
        private String nhifNumber;
        @JsonProperty("nssfNo")
        private String nssfNumber;

        public Long getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Long departmentId) {
            this.departmentId = departmentId;
        }

        public Long getDesignationId() {
            return designationId;
        }

        public void setDesignationId(Long designationId) {
            this.designationId = designationId;
        }

        public Date getJoiningDate() {
            return joiningDate;
        }

        public void setJoiningDate(Date joiningDate) {
            this.joiningDate = joiningDate;
        }

        public BigDecimal getSalaryAmount() {
            return salaryAmount;
        }

        public void setSalaryAmount(BigDecimal salaryAmount) {
            this.salaryAmount = salaryAmount;
        }

        public Long getSupervisorId() {
            return supervisorId;
        }

        public void setSupervisorId(Long supervisorId) {
            this.supervisorId = supervisorId;
        }

        public String getKraPinNumber() {
            return kraPinNumber;
        }

        public void setKraPinNumber(String kraPinNumber) {
            this.kraPinNumber = kraPinNumber;
        }

        public String getNhifNumber() {
            return nhifNumber;
        }

        public void setNhifNumber(String nhifNumber) {
            this.nhifNumber = nhifNumber;
        }

        public String getNssfNumber() {
            return nssfNumber;
        }

        public void setNssfNumber(String nssfNumber) {
            this.nssfNumber = nssfNumber;
        }
    }
}
