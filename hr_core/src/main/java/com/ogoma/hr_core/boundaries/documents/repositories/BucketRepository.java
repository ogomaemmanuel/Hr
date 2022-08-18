package com.ogoma.hr_core.boundaries.documents.repositories;

import com.ogoma.hr_core.boundaries.documents.entities.Bucket;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends BaseRepo<Bucket> {
}
