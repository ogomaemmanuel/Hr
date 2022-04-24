package com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date startDate;
    private Date endDate;
    private BigDecimal cost;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_type_id")
    private TrainingType trainingType;
    @JoinTable(name = "employee_training")
    @ManyToMany(cascade = CascadeType.ALL)
    List<Employee> employees;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void addEmployee(Employee employee) {
        List<Employee> employees = this.getEmployees();
        employees = employees == null ? new ArrayList<>() : employees;
        if (employee != null) {
            employees.add(employee);
        }
    }
    public void addEmployees(List<Employee> employees) {
        List<Employee> attachedEmployees = this.getEmployees();
        attachedEmployees = employees == null ? new ArrayList<>() : attachedEmployees;
        attachedEmployees.addAll(employees);
    }
}
