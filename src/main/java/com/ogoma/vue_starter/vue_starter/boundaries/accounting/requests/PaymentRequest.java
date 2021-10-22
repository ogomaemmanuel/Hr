package com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentRequest {
    private BigDecimal amount;
    private Long invoiceId;
    private Date paymentDate;

}
