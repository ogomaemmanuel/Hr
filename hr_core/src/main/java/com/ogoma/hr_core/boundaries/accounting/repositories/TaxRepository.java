package com.ogoma.hr_core.boundaries.accounting.repositories;

import com.ogoma.hr_core.boundaries.accounting.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Long> {
}
