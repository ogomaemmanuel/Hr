package com.ogoma.hr_core.boundaries.project_management.models;

public interface TeamMemberProjection {
    public Long getId();

    public String getFirstName();

    public String getLastName();

    public String getDesignation();

    public Long getEmployeeId();

    public Long getProjectId();

    public String getProjectName();

    public default String getFullName() {
        String lastName = null;
        if (null != getLastName()) {
            lastName = getLastName();
        }
        if (null != getFirstName()) {
            return getFirstName().concat(" ").concat(lastName);
        }
        return lastName;
    }
}
