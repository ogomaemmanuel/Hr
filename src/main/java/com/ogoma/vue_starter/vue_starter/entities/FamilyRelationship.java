package com.ogoma.vue_starter.vue_starter.entities;

import com.ogoma.vue_starter.vue_starter.utils.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "family_relationships")
public class FamilyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //    should be in small letters slug separated by _
    private String code;

    public FamilyRelationship() {

    }


    public Long getId() {
        return id;
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
    @PrePersist
    public void slugifyName() {
        this.code = StringUtils.slugify(this.name);
    }
}
