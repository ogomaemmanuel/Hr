package com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private BigDecimal rate;
    private String description;
    @OneToOne
    private Client client;
    @ManyToOne
    private Employee teamLeader;
    @OneToMany
    private Set<Employee> projectMembers;
}
