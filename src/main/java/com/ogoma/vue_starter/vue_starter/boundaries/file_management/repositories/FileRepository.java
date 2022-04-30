package com.ogoma.vue_starter.vue_starter.boundaries.file_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.file_management.entities.File;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends BaseRepo<File> {
    @Override
    Optional<File> findById(Long id);

    List<File> findAllByParentId(Long id);
    List<File> findAllByParentId(Long id,Sort sort);

}
