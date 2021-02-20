package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> , JpaSpecificationExecutor<Designation> {
    Page<Designation> findAllByDeletedFalse(Pageable pageable);
    @Query(value = "select d from Designation d join fetch Department dep")
    List<Designation> findAllByDepartmentId(Long departId);
}
