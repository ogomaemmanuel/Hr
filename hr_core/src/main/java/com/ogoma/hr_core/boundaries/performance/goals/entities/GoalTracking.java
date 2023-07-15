package com.ogoma.hr_core.boundaries.performance.goals.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;

@Table(name = "goal_tracking")
@Entity
public class GoalTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer progress;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Goal goal;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
