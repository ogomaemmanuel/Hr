package com.ogoma.vue_starter.vue_starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RolePermission {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties("rolePermissions")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "permission_id")
    @JsonIgnoreProperties("rolePermissions")
    private Permission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
