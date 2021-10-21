package com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentRepository extends JpaRepository<Payment,Long> , JpaSpecificationExecutor<Payment> {
}
