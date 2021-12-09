package com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice,Long>, JpaSpecificationExecutor<Invoice> {
   @Query(value = "select inv from Invoice inv left join fetch inv.items left join fetch inv.client where inv.id=:id")
    Optional<Invoice> getInvoiceById(Long id);
}
