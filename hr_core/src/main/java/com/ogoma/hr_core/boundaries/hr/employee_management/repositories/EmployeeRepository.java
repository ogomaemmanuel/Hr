package com.ogoma.hr_core.boundaries.hr.employee_management.repositories;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.hr_core.boundaries.hr.employee_management.models.EmployeeQuery;
import com.ogoma.hr_core.boundaries.payroll.models.EmployeeSalaryViewModel;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.enums.GenderEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepo<Employee> {


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
            "    users u ON e.id = u.id left join designations dsg on e.designation_id=dsg.id where e.deleted=0",
            countQuery = "SELECT \n" +
                    "   count(e.id)\n" +
                    "FROM\n" +
                    "    employees e\n" +
                    "        LEFT JOIN\n" +
                    "    users u ON e.id = u.id left join designations dsg on e.designation_id=dsg.id where e.deleted=0",
            nativeQuery = true)
    public Page<EmployeeQuery> getAllEmployees(Pageable pageable);

    public List<Employee> findAllByGender(GenderEnum gender);


    @Query(value = "SELECT \n" +
            "    e.id,\n" +
            "    e.joining_date AS joiningDate,\n" +
            "    u.first_name AS firstName,\n" +
            "    u.last_name AS lastName,\n" +
            "    u.email as email,\n" +
            "    e.salary_amount as salaryAmount,\n" +
            "    u.phone,\n" +
            "    u.date_of_birth as dateOfBirth,\n" +
            "    dsg.name as designation\n" +
            "    \n" +
            "FROM\n" +
            "    employees e\n" +
            "        LEFT JOIN\n" +
            "    users u ON e.id = u.id left join designations dsg on e.designation_id=dsg.id where e.deleted=0",
            countQuery = "SELECT \n" +
                    "   count(e.id)\n" +
                    "FROM\n" +
                    "    employees e\n" +
                    "        LEFT JOIN\n" +
                    "    users u ON e.id = u.id left join designations dsg on e.designation_id=dsg.id where e.deleted=0",
            nativeQuery = true)
    public Page<EmployeeSalaryViewModel> getEmployeesSalary(Pageable pageable);

    @Query(value = "SELECT \n" +
            "    e.id,\n" +
            "    e.joining_date AS joiningDate,\n" +
            "    u.first_name AS firstName,\n" +
            "    u.last_name AS lastName,\n" +
            "    u.email as email,\n" +
            "    e.salary_amount as salaryAmount,\n" +
            "    u.phone,\n" +
            "    u.date_of_birth as dateOfBirth,\n" +
            "    d.name as departmentName,\n" +
            "    dsg.name as designation\n" +
            "    \n" +
            "FROM\n" +
            "    employees e\n" +
            "        LEFT JOIN\n" +
            "    users u ON e.id = u.id left join" +
            " designations dsg on e.designation_id=dsg.id" +
            " left join departments d on e.department_id = d.id" +
            " where e.deleted=0 and e.id=:employeeId",nativeQuery=true)
    public EmployeeSalaryViewModel getEmployeeSalaryByEmployeeId(Long employeeId);
}
