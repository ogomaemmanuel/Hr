package com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.entities;

import com.ogoma.vue_starter.vue_starter.entities.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "holidays")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted = false")
@SQLDelete(sql = "update holidays set deleted=true where id=?")
public class Holiday extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Holiday name is required")
    private String name;
    @NotNull(message = "Holiday date is required")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public Holiday setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Holiday setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Holiday setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Holiday setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Holiday setDate(Date date) {
        this.date = date;
        return this;
    }
}
