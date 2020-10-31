package com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.enums.Priority;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.enums.RateType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Start date is required")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @NotNull(message = "End date is required")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @NotNull(message = "Rate is required")
    private BigDecimal rate;
    @NotNull(message = "Type is required")
    private RateType rateType;
    @NotBlank(message = "Description is required")
    private String description;
    @Column(name = "client_id")
    private Long clientId;
    @OneToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;
    @Column(name = "team_leader_id")
    private Long teamLeaderId;
    @ManyToOne
    @JoinColumn(name = "team_leader_id", updatable = false, insertable = false)
    private Employee teamLeader;
    @OneToMany
    private Set<Employee> projectMembers = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;


    public Long getId() {
        return id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Employee teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Set<Employee> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(Set<Employee> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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
}
