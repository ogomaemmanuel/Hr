package com.ogoma.vue_starter.vue_starter.entities;

import javax.persistence.*;

@Entity
@Table(name = "application-configuration")
public class AppConfig {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String key;
    private String value;
    private String description;
    public long getId() {
        return id;
    }

    public AppConfig setId(long id) {
        this.id = id;
        return this;
    }

    public String getKey() {
        return key;
    }

    public AppConfig setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public AppConfig setValue(String value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AppConfig setDescription(String description) {
        this.description = description;
        return this;
    }
}
