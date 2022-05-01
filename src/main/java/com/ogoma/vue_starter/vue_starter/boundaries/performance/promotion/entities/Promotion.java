package com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_promotion")
public class Promotion {
    @Id
    private Long id;
    @ManyToOne
    private Designation from;
    @ManyToOne
    private Designation to;
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionDate;
    @ManyToOne
    private Employee employee;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Designation getFrom() {
        return from;
    }

    public void setFrom(Designation from) {
        this.from = from;
    }

    public Designation getTo() {
        return to;
    }

    public void setTo(Designation to) {
        this.to = to;
    }

    public Date getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
