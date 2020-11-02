package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import java.util.Date;

public interface ProjectProjection {
    public Long getId();

    public String getDescription();

    public String getClientName();

    public String getName();

    public Long getTeamLeaderId();

    public String getTeamLeaderFirstName();

    public String getTeamLeaderLastName();

    public Date getStartDate();

    public Date getEndDate();

    public String getPriority();

    public String getRate();

    public String getRateType();

    public Integer getCompleteTasks();

    public Integer getOpenTasks();

    public Integer getMemberCount();
}
