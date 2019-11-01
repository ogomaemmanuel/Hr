package com.ogoma.vue_starter.vue_starter.boundaries.documents.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "buckets")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private Date createdOn;
    private Date updatedOn;

    public Long getId() {
        return id;
    }

    public Bucket setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bucket setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Bucket setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Bucket setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
