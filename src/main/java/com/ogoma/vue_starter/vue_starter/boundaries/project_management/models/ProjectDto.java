package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.enums.Priority;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.enums.RateType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Start date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDate;
    @NotNull(message = "End date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endDate;
    @NotNull(message = "Rate is required")
    private BigDecimal rate;
    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private RateType rateType;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Select a client")
    private Long clientId;
    @NotNull(message = "Select a team leader")
    private Long teamLeaderId;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Assign priority")
    private Priority priority;
    @Size(min = 1)
    @NotEmpty(message = "Select at least one team member")
    private List<Long> projectMembersIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getRate() {
        return rate;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Long teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public List<Long> getProjectMembersIds() {
        return projectMembersIds;
    }

    public void setProjectMembersIds(List<Long> projectMembersIds) {
        this.projectMembersIds = projectMembersIds;
    }
}
