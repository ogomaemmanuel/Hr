package com.ogoma.hr_core.boundaries.accounting.models;

import com.ogoma.hr_core.boundaries.accounting.entities.Invoice;
import com.ogoma.hr_core.boundaries.accounting.specifications.InvoiceSpecification;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Date;

public class InvoicePagedDataRequest extends PagedDataRequest {
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
    public Specification<Invoice> getSpecification() {
        return InvoiceSpecification.getInvoiceSpec(this);
    }

}
