package com.ogoma.vue_starter.vue_starter.boundaries.documents.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date createdOn;
    private  Date updatedOn;

    public Long getId() {
        return id;
    }

    public Document setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Document setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Document setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
