package com.ogoma.hr_core.boundaries.performance.promotion.requests;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PromotionRequest {
    private Date promotionDate;
    private Long employeeId;
    private Long fromDesignationId;
    private Long toDesignationId;

    public Date getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getFromDesignationId() {
        return fromDesignationId;
    }

    public void setFromDesignationId(Long fromDesignationId) {
        this.fromDesignationId = fromDesignationId;
    }

    public Long getToDesignationId() {
        return toDesignationId;
    }

    public void setToDesignationId(Long toDesignationId) {
        this.toDesignationId = toDesignationId;
    }
}
