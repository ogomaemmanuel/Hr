package com.ogoma.hr_core.boundaries.performance.training.repository;

import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.boundaries.performance.training.entities.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTypeRepository extends BaseRepo<TrainingType> {

}
