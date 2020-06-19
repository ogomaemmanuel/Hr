package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT \n" +
            "    e.id,\n" +
            "    e.joining_date AS joiningDate,\n" +
            "    u.first_name AS firstName,\n" +
            "    u.last_name AS lastName,\n" +
            "    u.email as email,\n" +
            "    u.phone,\n" +
            "    u.date_of_birth as dateOfBirth,\n" +
            "    dsg.name as designation\n" +
            "    \n" +
            "FROM\n" +
            "    employees e\n" +
            "        LEFT JOIN\n" +
            "    users u ON e.user_id = u.id left join designations dsg on e.designation_id=dsg.id",
            countQuery = "SELECT \n" +
                    "   count(e.id)\n" +
                    "FROM\n" +
                    "    employees e\n" +
                    "        LEFT JOIN\n" +
                    "    users u ON e.user_id = u.id left join designations dsg on e.designation_id=dsg.id",
            nativeQuery = true)
    public Page<EmployeeQuery> getAllEmployees(Pageable pageable);

}
