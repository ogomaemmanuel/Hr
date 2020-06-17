package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "terminated_employees")
public class TerminatedEmployee {
    // details of employees who have been terminated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private Employee employee;
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalPayDate;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getFinalPayDate() {
        return finalPayDate;
    }

    public void setFinalPayDate(Date finalPayDate) {
        this.finalPayDate = finalPayDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAte() {
        return updatedAte;
    }

    public void setUpdatedAte(Date updatedAte) {
        this.updatedAte = updatedAte;
    }
}
