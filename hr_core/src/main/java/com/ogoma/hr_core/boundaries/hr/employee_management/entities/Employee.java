package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.entities.BaseEntity;
import com.ogoma.hr_core.enums.GenderEnum;
import com.ogoma.hr_core.enums.converters.GenderEnumConverter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "employees")
@SQLDelete(sql = "update employees set deleted=true,deleted_at=now()  where id=?")
public class Employee extends BaseEntity {
    @Id
    private Long id;
    private Date joiningDate;
    @Column(name = "supervisor_id")
    private Long supervisorId;
    @Column(name = "designation_id")
    private Long designationId;
    @Column(name = "bank_id")
    private Long bankId;
    @Column(name = "bank_branch_id")
    private Long bankBranchId;
    @Column(name = "account_no")
    private String accountNo;
    private BigDecimal salaryAmount;
    @Column(unique = true)
    private String nssfNumber;
    @Column(unique = true)
    private String kraPinNumber;
    @Column(unique = true)
    private String nhifNumber;
    @Convert(converter = GenderEnumConverter.class)
    private GenderEnum gender;
    @OneToOne( cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id", insertable = false, updatable = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Designation designation;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = "employee")
    private List<EmployeeContactAddress> employeeContactAddresses = new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "supervisor_id", insertable = false, updatable = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Employee supervisor;
    @Column(name = "status")
    private Boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedOn;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, insertable = false)
    private Department department;
    @Column(name = "department_id")
    private Long departmentId;
    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Long getBankId() {
        return bankId;
    }

    public Employee setBankId(Long bankId) {
        this.bankId = bankId;
        return this;
    }

    public Long getBankBranchId() {
        return bankBranchId;
    }

    public Employee setBankBranchId(Long bankBranchId) {
        this.bankBranchId = bankBranchId;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public Employee setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(BigDecimal salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getNssfNumber() {
        return nssfNumber;
    }

    public void setNssfNumber(String nssfNumber) {
        this.nssfNumber = nssfNumber;
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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public Employee setUser(User user) {
        this.user = user;
        return this;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Employee setDesignation(Designation designation) {
        this.designation = designation;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Employee setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Employee setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Employee setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public List<EmployeeContactAddress> getEmployeeContactAddresses() {
        return employeeContactAddresses;
    }

    public void setEmployeeContactAddresses(List<EmployeeContactAddress> employeeContactAddresses) {
        employeeContactAddresses.forEach(add -> {
            add.setEmployee(this);
        });
        this.employeeContactAddresses = employeeContactAddresses;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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
}
