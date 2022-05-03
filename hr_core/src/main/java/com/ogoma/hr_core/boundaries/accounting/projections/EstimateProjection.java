package com.ogoma.hr_core.boundaries.accounting.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface EstimateProjection {
    Long getId();
    Long getClientId();
    Date getEstimateDate();
    Date getEstimateExpiryDate();
    String getClientFirstName();
    String getClientLastName();
    String getClientCompany();
    BigDecimal getAmount();

}