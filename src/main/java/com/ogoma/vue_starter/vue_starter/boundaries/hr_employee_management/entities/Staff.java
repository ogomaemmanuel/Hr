package com.ogoma.vue_starter.vue_starter.boundaries.hr_employee_management.entities;

import com.ogoma.vue_starter.vue_starter.entities.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "designation_id",insertable = false,updatable = false)
    private Designation designation;

    private BigDecimal salary;
    @Column(name = "status")
    private Boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public Long getId() {
        return id;
    }

    public Staff setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Staff setUser(User user) {
        this.user = user;
        return this;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Staff setDesignation(Designation designation) {
        this.designation = designation;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Staff setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Staff setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Staff setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Staff setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
