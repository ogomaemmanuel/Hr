package com.ogoma.vue_starter.vue_starter.boundaries.banks.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonProperty("bank_code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private List<BankBranch> branches;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<BankBranch> branches) {
        this.branches = branches;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
