package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    private Long id;
    private Date invoiceDate;
    private Date dueDate;
    @ManyToOne
    private Client client;
    @OneToOne
    private Project project;
    private String otherInformation;
    private BigDecimal percentageDiscount;
    private BigDecimal taxAmount;
    private BigDecimal grandTotal;
}
