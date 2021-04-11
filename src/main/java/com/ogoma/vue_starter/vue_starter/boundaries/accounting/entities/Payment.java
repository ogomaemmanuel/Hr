package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {
    public enum PaymentTypes{
        Cheque,
        Paypal,
        Cash,
        Mpesa

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Date paymentDate;
    @ManyToOne
    private Client client;
    @Enumerated(EnumType.STRING)
    private PaymentTypes paymentTypes;

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PaymentTypes getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(PaymentTypes paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
}
