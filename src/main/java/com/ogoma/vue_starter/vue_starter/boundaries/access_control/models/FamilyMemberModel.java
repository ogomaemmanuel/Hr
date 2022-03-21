package com.ogoma.vue_starter.vue_starter.boundaries.access_control.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmergencyContactModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class FamilyMemberModel {

    @JsonProperty("members")
    private List<Member> members;
    private Long userId;

    public List<Member> getMembers() {
        return members;
    }
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static class Member {
        Long id;
        @NotBlank(message = "Name is required")
        private String name;
        @NotNull(message = "Relationship is required")
        private Long relationshipId;
        @NotBlank(message = "Phone number one required")
        private String PhoneNumber;
        @NotNull(message = "Date of Birth is required")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dob;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getRelationshipId() {
            return relationshipId;
        }

        public void setRelationshipId(Long relationshipId) {
            this.relationshipId = relationshipId;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
