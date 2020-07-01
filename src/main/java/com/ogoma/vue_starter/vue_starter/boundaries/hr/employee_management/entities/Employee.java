package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.entities.BaseEntity;
import com.ogoma.vue_starter.vue_starter.enums.GenderEnum;
import com.ogoma.vue_starter.vue_starter.enums.converters.GenderEnumConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "employees")
@SQLDelete(sql = "update employees set deleted=true,deleted_at=now()  where id=?")
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date joiningDate;
    @Column(name = "supervisor_id")
    private Long supervisorId;
    @Column(name = "designation_id")
    private Long designationId;
    private BigDecimal salaryAmount;
    private String nssfNumber;
    private String kraPinNumber;
    private String nhifNumber;
    @Convert(converter = GenderEnumConverter.class)
    private GenderEnum gender;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "designation_id", insertable = false, updatable = false)
    private Designation designation;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = "employee")
    private List<EmployeeContactAddress> employeeContactAddresses = new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "supervisor_id", insertable = false, updatable = false)
    private Employee supervisor;
    @Column(name = "status")
    private Boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedOn;
    @ManyToOne(cascade = CascadeType.PERSIST)
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
