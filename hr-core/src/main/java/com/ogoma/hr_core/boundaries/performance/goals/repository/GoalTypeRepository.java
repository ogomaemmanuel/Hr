package com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.entities.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTypeRepository extends JpaRepository<GoalType,Long> ,
        JpaSpecificationExecutor<GoalType> {

}
