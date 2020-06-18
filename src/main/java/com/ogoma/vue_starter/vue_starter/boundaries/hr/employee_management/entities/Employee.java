package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.enums.GenderEnum;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date joiningDate;
    private Date dateOfBirth;
    private BigDecimal salaryAmount;
    private String nssfNumber;
    private String kraNumber;
    private String nhifNumber;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "designation_id", insertable = false, updatable = false)
    private Designation designation;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Set<EmployeeContactAddress> employeeContactAddresses=new HashSet<>();

    private BigDecimal salary;
    @Column(name = "status")
    private Boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedOn;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getKraNumber() {
        return kraNumber;
    }

    public void setKraNumber(String kraNumber) {
        this.kraNumber = kraNumber;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
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

    public Set<EmployeeContactAddress> getEmployeeContactAddresses() {
        return employeeContactAddresses;
    }

    public void setEmployeeContactAddresses(Set<EmployeeContactAddress> employeeContactAddresses) {
        employeeContactAddresses.forEach(add -> {
            add.setEmployee(this);
        });
        this.employeeContactAddresses = employeeContactAddresses;
    }
}
