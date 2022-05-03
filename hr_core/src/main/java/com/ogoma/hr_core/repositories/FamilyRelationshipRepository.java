package com.ogoma.hr_core.repositories;

import com.ogoma.hr_core.entities.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship,Long> {
}
