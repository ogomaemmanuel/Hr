package com.ogoma.vue_starter.vue_starter.repositories;

import com.ogoma.vue_starter.vue_starter.entities.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship,Long> {
}
