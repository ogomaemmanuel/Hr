package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public String getClientFirstName();

    public Long getClientId();

    public String getClientLastName();

    public Date getCreatedAt();

    public default long getTotalHours() {
        long millisecondsDiff =
                Math.abs(this.getEndDate().getTime() - this.getStartDate().getTime());
        long totalHours = TimeUnit.HOURS.convert(millisecondsDiff, TimeUnit.MILLISECONDS);
        return totalHours;
    }
}
