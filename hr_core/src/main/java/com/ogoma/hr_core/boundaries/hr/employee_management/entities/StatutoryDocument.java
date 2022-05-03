package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import javax.persistence.*;

@Entity
@Table(name = "statutory_documents")
public class StatutoryDocument {
    // this will contains the names of statutoryDocuments such Id, nssf Number, KraPin etc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}
