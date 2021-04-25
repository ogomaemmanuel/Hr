package com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
public class JobRequest {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Vacancies is required")
    private Integer vacancies;
    @NotNull(message = "Minimum salary is required")
    private BigDecimal minimumSalary;
    @NotNull(message = "Maximum salary is required")
    private BigDecimal maximumSalary;
    @NotNull(message = "Start date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @NotNull(message = "End date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private String description;
    private Integer age;
    private String experience;
    @NotNull(message = "Select department")
    private Long departmentId;
    @Enumerated(EnumType.STRING)
    private Job.Status status;
    @NotNull(message = "Select job type")
    @Enumerated(EnumType.STRING)
    private Job.JobType type;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public BigDecimal getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(BigDecimal minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public BigDecimal getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(BigDecimal maximumSalary) {
        this.maximumSalary = maximumSalary;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Job.Status getStatus() {
        return status;
    }

    public void setStatus(Job.Status status) {
        this.status = status;
    }

    public Job.JobType getType() {
        return type;
    }

    public void setType(Job.JobType type) {
        this.type = type;
    }
}
