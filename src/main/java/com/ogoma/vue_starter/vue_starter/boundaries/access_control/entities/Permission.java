package com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.vue_starter.vue_starter.utils.StringUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Permission() {

    }

    public Permission(String name) {
        this.name = name;
        this.code = code;
    }

    @OneToMany(mappedBy =  RolePermission_.ROLE)
    @JsonIgnoreProperties(RolePermission_.PERMISSION)
    private Set<RolePermission> rolePermissions;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    @PrePersist
    public void slugifyCode() {
        this.code = StringUtils.slugify(this.name);
    }
}
