package com.ogoma.vue_starter.vue_starter.boundaries.asset_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<Asset,Long> , JpaSpecificationExecutor<Asset> {
}
