package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import javax.persistence.*;

@Entity
@Table(name = "termination_reasons")
public class TerminationReason {
    //reasons for terminating an employee, will appear as drop down when terminating an employee
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
