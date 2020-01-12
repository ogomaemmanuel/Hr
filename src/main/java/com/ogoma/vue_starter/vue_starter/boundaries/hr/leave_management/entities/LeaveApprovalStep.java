package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import javax.persistence.*;

//@Entity
//@Table(name ="leave_approval_steps" )
public class LeaveApprovalStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer order;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public LeaveApprovalStep setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LeaveApprovalStep setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public LeaveApprovalStep setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public LeaveApprovalStep setActive(boolean active) {
        isActive = active;
        return this;
    }
}
