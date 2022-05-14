package com.ogoma.hr_core.boundaries.accounting.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chart_of_accounts")
public class ChartOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String norminalCode;
    private String name;
    //Determines which module
    @ElementCollection
    private List<String> visibilityAreas;

    public Long getId() {
        return id;
    }

    public String getNorminalCode() {
        return norminalCode;
    }

    public void setNorminalCode(String norminalCode) {
        this.norminalCode = norminalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getVisibilityAreas() {
        return visibilityAreas;
    }

    public void setVisibilityAreas(List<String> visibilityAreas) {
        this.visibilityAreas = visibilityAreas;
    }
}
