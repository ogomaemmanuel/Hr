package com.ogoma.hr_core.boundaries.performance.appraisals.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appraisals")
public class Appraisal {
    public enum AppraisalStatus {
        SUBMITED, DRAFT,
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AppraisalCycle appraisalCycle;
    @ManyToOne
    private Employee employee;
    @OneToMany
    private List<EmployeeKeyResultScore> employeeKeyResultScore;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    @Enumerated(value = EnumType.STRING)
    private AppraisalStatus appraisalStatus;
}
