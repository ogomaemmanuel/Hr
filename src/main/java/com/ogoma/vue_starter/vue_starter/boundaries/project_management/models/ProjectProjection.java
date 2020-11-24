package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface ProjectProjection {
    public Long getId();

    public String getDescription();

    public String getClientName();

    public String getName();

    public Long getLeadEmployeeId();

    public String getLeadFirstName();

    public String getLeadLastName();

    public String getLeadDesignation();

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

    public default String getClientFullName() {
        String lastName = this.getClientLastName();
        String firstName = this.getClientFirstName();
        if (null != firstName) {
            return firstName.concat(" ").concat(lastName);
        }
        return lastName;
    }

    public default String getLeadFullName() {
        String lastName = this.getLeadLastName();
        String firstName = this.getLeadFirstName();
        if (null != firstName) {
            return firstName.concat(" ").concat(lastName);
        }
        return lastName;
    }
}
