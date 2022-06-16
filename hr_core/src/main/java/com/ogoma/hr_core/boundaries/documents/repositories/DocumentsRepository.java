package com.ogoma.hr_core.boundaries.documents.repositories;

import com.ogoma.hr_core.boundaries.documents.entities.CloudObject;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends BaseRepo<CloudObject> {
}
