package com.ogoma.hr_core.boundaries.asset_management.repositories;

import com.ogoma.hr_core.boundaries.asset_management.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<Asset,Long> , JpaSpecificationExecutor<Asset> {
}
