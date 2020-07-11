package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeResignation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeResignationView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeResignationRepository extends JpaRepository<EmployeeResignation, Long> {
    @Query(value = "select er.id,\n" +
            "       u.first_name        as employeeFirstName,\n" +
            "       u.last_name         as employeeLastName,\n" +
            "       er.notice_date      as noticeDate,\n" +
            "       d.name      as employeeDepartment,\n" +
            "       er.reason as reason,\n" +
            "       er.resignation_date as resignationDate\n" +
            "from employee_resignations er\n" +
            "         left join employees e on er.employee_id = e.id\n" +
            "         left join departments d on e.department_id = d.id\n" +
            "         left join users u on e.user_id = u.id",
            nativeQuery = true,
            countQuery = "select count(*)\n" +
                    "from employee_resignations er\n" +
                    "         left join employees e on er.employee_id = e.id\n" +
                    "         left join users u on e.user_id = u.id"
    )
    public Page<EmployeeResignationView> getAll(Pageable pageable);
}
