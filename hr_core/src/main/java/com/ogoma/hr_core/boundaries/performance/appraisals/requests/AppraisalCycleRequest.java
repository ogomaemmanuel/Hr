package com.ogoma.hr_core.boundaries.performance.appraisals.requests;

import java.time.LocalDate;

public class AppraisalCycleRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate dueDate;
    private Long evaluatorID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getEvaluatorID() {
        return evaluatorID;
    }

    public void setEvaluatorID(Long evaluatorID) {
        this.evaluatorID = evaluatorID;
    }
}
