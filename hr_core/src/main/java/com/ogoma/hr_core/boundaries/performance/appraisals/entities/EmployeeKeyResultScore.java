package com.ogoma.hr_core.boundaries.performance.appraisals.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;

@Entity
@Table(name = "employee_key_result_scores")
public class EmployeeKeyResultScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private KeyResultArea keyResultArea;
}
