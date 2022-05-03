package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import com.ogoma.hr_core.utils.StringUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "termination_reasons")
public class TerminationReason implements Serializable {
    //reasons for terminating an employee, will appear as drop down when terminating an employee

    public TerminationReason() {

    }

    public TerminationReason(String name) {
        this.name = name;
    }

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
