package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import com.ogoma.vue_starter.vue_starter.utils.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "termination_reasons")
public class TerminationReason {
    //reasons for terminating an employee, will appear as drop down when terminating an employee
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @PrePersist
    public void slugifyCode() {
        this.code = StringUtils.slugify(this.name);
    }
}
