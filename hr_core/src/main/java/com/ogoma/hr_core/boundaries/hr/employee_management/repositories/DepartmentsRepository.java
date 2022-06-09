package com.ogoma.hr_core.boundaries.hr.employee_management.repositories;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Department;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends BaseRepo<Department> {

    Page<Department> findAllByDeletedFalse(Pageable pageable);

}
