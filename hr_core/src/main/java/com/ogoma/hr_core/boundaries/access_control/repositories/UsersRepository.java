package com.ogoma.hr_core.boundaries.access_control.repositories;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UsersRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    @Nullable
    User findByEmail(String email);
    @Query(value = "SELECT u.* FROM users u left join employees s on u.id=s.user_id where s.id=:id",nativeQuery = true)
    User findByStaffId(Long id);
    @Query(value = "Select u From User u left join fetch Employee e",
            countQuery = "select count(u) from User u")
    Page<User> findAll(Pageable pageable);

    @Query(value = "select u.id, concat_ws(' ',u.first_name,u.last_name) fullname, e.salary_amount salary, u.identity_no idNo, " +
            "d.name department, u.email, ms.name maritalStatus, e.nhif_number nhifNo, e.nssf_number nssfNo, e.kra_pin_number kraPin, " +
            "b.name bankName, bb.name bankBranch, e.account_no accountNo, " +
            "u.phone, date_format(joining_date,'%Y-%m-%d') employmentDate " +
            "from users u left join employees e on e.id = u.id " +
            "left join marital_statuses ms on u.marital_status_id = ms.id " +
            "left join banks b on e.bank_id = b.id " +
            "left join bank_branches bb on e.bank_branch_id = bb.id " +
            "left join departments d on e.department_id = d.id where u.id = :id", nativeQuery = true)
    Map<String,String> findUserDetails(Long id);
}
