package com.ogoma.hr_core.boundaries.performance.appraisals.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "appraisal_cycles")
@Entity
public class AppraisalCycle {
    //    Orange hrm
    public enum Status {
        OPEN, REOPENED, CLOSED, CREATED, APPRAISALS_CREATED
    }
    public enum ReportingMethod {
        DIRECT, INDIRECT
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee evaluator;
    private String name;
    private LocalDate dueDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Employee getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Employee evaluator) {
        this.evaluator = evaluator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
