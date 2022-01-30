package com.ogoma.vue_starter.vue_starter.boundaries.training.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.training.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {
}
