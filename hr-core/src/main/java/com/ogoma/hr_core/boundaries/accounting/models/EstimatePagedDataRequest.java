package com.ogoma.vue_starter.vue_starter.boundaries.accounting.models;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.specifications.EstimatesSpecification;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Date;

public class EstimatePagedDataRequest extends PagedDataRequest {
    private Long clientId;
    private Date startDate;
    private Date estimateDate;
    private Date endDate;
    private String status;
    private BigDecimal amount;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Specification<Estimate> getSpecification() {
        return EstimatesSpecification.getEstimatesSpec(this);
    }
}
