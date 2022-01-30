package com.ogoma.vue_starter.vue_starter.boundaries.training.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.training.entities.Trainer;

import java.util.Date;

public class TrainerRequest {
    private String firstName;
    private String lastName;
    private  String email;
    private String role;
    private  String description;
    private Trainer.Status status;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainer.Status getStatus() {
        return status;
    }

    public void setStatus(Trainer.Status status) {
        this.status = status;
    }
}
