package com.ogoma.hr_core.boundaries.accounting.repositories;

import com.ogoma.hr_core.boundaries.accounting.entities.ProvidentFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidentFundRepository extends JpaRepository<ProvidentFund,Long>, JpaSpecificationExecutor<ProvidentFund> {
}
