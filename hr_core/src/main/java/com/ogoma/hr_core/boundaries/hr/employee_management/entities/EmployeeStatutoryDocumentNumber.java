package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import javax.persistence.*;

@Entity
public class EmployeeStatutoryDocumentNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private StatutoryDocument statutoryDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutoryDocument getStatutoryDocument() {
        return statutoryDocument;
    }

    public void setStatutoryDocument(StatutoryDocument statutoryDocument) {
        this.statutoryDocument = statutoryDocument;
    }
}
