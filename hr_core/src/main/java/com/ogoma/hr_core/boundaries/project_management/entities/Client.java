package com.ogoma.hr_core.boundaries.project_management.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.hr_core.boundaries.access_control.entities.User;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String description;
    private String address;
    @Transient
    @JsonProperty
    private String fullName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    @Valid
    private User user;

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        if (this.user != null) {
            return this.user.getFullName();
        }
        return "";
    }
}
