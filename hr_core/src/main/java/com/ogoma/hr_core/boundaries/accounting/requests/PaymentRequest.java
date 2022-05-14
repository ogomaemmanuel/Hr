package com.ogoma.hr_core.boundaries.accounting.requests;

import com.ogoma.hr_core.boundaries.accounting.entities.Payment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentRequest {
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Long invoiceId;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date paymentDate;
    private String notes;

    private Payment.PaymentTypes paymentType;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Payment.PaymentTypes getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Payment.PaymentTypes paymentType) {
        this.paymentType = paymentType;
    }
}
