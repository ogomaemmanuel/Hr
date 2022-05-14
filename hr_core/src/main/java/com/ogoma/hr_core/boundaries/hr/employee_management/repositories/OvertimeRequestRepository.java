package com.ogoma.hr_core.boundaries.hr.employee_management.repositories;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.OvertimeRequestView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OvertimeRequestRepository extends JpaRepository<OvertimeRequest, Long> {
    @Query(value = "select ovr.id,\n" +
            "       u.first_name       as employeeFirstName,\n" +
            "       u.last_name        as employeeLastName,\n" +
            "       ovr.overtime_date  as overtimeDate,\n" +
            "       ovr.description  as description,\n" +
            "       ovr.overtime_hours as overtimeHours\n" +
            "from overtime_requests  ovr\n" +
            "         left join employees e on ovr.employee_id = e.id\n" +
            "         left join users u on e.id = u.id",
            nativeQuery = true,
            countQuery = "select count(ovr.id)\n" +
                    "from overtime_requests  ovr\n" +
                    "         left join employees e on ovr.employee_id = e.id\n" +
                    "         left join users u on e.id = u.id")
    public Page<OvertimeRequestView> getAllActive(Pageable pageable);
     @Query(value = "select ovr.id,\n" +
            "       u.first_name       as employeeFirstName,\n" +
            "       u.last_name        as employeeLastName,\n" +
            "       ovr.overtime_date  as overtimeDate,\n" +
            "       ovr.description  as description,\n" +
            "       ovr.overtime_hours as overtimeHours\n" +
            "from overtime_requests  ovr\n" +
            "         left join employees e on ovr.employee_id = e.id\n" +
            "         left join users u on e.id = u.id",nativeQuery=true)
    public List<OvertimeRequestView> getAllActive();
}
