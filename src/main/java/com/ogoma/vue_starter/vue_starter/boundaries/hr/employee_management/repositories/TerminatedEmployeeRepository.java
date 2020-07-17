package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.TerminatedEmployeeView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TerminatedEmployeeRepository extends JpaRepository<TerminatedEmployee, Long> {
    @Query(value = "select te.id,\n" +
            "       u.first_name        as emoloyeeFirstName,\n" +
            "       u.last_name         as employeeLastName,\n" +
            "       te.notice_date      as noticeDate,\n" +
            "       te.reason as reason,\n" +
            "       te.termination_date as terminationDate,\n" +
            "       tr.name as terminationType\n" +
            "from terminated_employees te\n" +
            "         left join employees e on te.employee_id = e.id\n" +
            "         left join users u on e.user_id = u.id left join  termination_reasons tr on te.termination_reason_code = tr.code",
            nativeQuery = true,
            countQuery = "select count(*)\n" +
                    "from terminated_employees te\n" +
                    "         left join employees e on te.employee_id = e.id")
    public Page<TerminatedEmployeeView> getAll(Pageable pageable);

}
