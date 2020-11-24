package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import java.util.List;

public class ProjectMemberUpdateDto {
    private List<Long> teamMembers;

    public List<Long> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Long> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
