package com.ogoma.hr_core.boundaries.accounting.repositories;

import com.ogoma.hr_core.boundaries.accounting.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> , JpaSpecificationExecutor<Payment> {
}
