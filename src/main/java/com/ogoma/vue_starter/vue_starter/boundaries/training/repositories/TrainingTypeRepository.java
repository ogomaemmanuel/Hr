package com.ogoma.vue_starter.vue_starter.boundaries.training.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.training.entities.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTypeRepository extends JpaRepository<TrainingType,Long> {
}
