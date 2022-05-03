package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_educational_info")
public class EmployeeEducationalnfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
