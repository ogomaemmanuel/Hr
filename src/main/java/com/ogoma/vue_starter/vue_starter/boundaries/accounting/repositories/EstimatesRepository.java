package com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimatesRepository extends JpaRepository<Estimate, Long> {
    @Query(value = "select amount,client_id as clientId,expiry_date as expiryDate,estimate_date as estimateDate," +
            "percentage_discount as percentageDiscount," +
            "c.company_name as clientCompany,u.first_name as clientFirstName" +
            " from estimates" +
            " left join clients c on c.id = estimates.client_id left join users u on u.id = c.user_id",
            countQuery = "select count(*) from estimates",
            nativeQuery = true)
    public Page<EstimateProjection> getEstimates(Pageable pageable);
}