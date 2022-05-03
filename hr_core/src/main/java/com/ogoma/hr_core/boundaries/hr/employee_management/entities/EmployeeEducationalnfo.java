package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_educational_info")
public class EmployeeEducationalnfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
