package com.ogoma.hr_core.boundaries.accounting.entities;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "taxes")
@EntityListeners(AuditingEntityListener.class)
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Max(value = 100, message = "Enter valid tax value")
    @Min(value = 0, message = "Enter a valid tax value")
    private BigDecimal percentageAmount;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
//    @JsonIgnoreProperties(value =
//            {User_.USER_ROLES,
//                    User_.EMPLOYEE,
//                    User_.PASSWORD_RESET_LIST})
   // @JsonIgnore
    User createdBy;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentageAmount() {
        return percentageAmount;
    }

    public void setPercentageAmount(BigDecimal percentageAmount) {
        this.percentageAmount = percentageAmount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
