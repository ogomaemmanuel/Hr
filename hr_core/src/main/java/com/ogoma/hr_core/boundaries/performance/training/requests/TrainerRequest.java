package com.ogoma.hr_core.boundaries.performance.training.requests;

import com.ogoma.hr_core.boundaries.performance.training.entities.Trainer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TrainerRequest {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    private String role;
    @NotBlank(message = "Phone number is required")
    private String phone;
    private String description;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
