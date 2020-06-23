package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chart_of_accounts")
public class ChartOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String norminalCode;
    private String name;
    //Determines which module
    @ElementCollection
    private List<String> visibilityAreas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
