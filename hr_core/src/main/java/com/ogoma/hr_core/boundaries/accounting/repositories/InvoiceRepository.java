package com.ogoma.hr_core.boundaries.accounting.repositories;

import com.ogoma.hr_core.boundaries.accounting.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice,Long>, JpaSpecificationExecutor<Invoice> {
}
