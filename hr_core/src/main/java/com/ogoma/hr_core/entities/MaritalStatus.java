package com.ogoma.hr_core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "marital_statuses")
public class MaritalStatus {
    public static final String MARRIED = "MA";
    public static final String WIDOWED = "WI";
    public static final String SINGLE = "SI";
    public static final String SEPARATED = "SE";
    public static final String DIVORCED = "DI";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public MaritalStatus() {

    }

    public MaritalStatus(String name, String code) {
        this.code = code;
        this.name = name;
    }

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
}
