package com.ogoma.vue_starter.vue_starter.boundaries.documents.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.documents.entities.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket,Long> {
}
