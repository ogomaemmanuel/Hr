package com.ogoma.hr_core.boundaries.performance.training.repository;

import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.boundaries.performance.training.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepository extends BaseRepo<Training> {

    @Query(value = "select t from Training t left join fetch t.trainer left join fetch t.employees")
    public Optional<Training> getTrainingByID(Long id);
}
