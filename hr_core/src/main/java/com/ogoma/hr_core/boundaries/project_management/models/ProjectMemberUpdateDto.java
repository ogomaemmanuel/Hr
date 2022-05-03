package com.ogoma.hr_core.boundaries.project_management.models;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ProjectMemberUpdateDto {
    @NotEmpty(message = "Select project team members")
    private List<Long> teamMembers;

    public List<Long> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Long> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
