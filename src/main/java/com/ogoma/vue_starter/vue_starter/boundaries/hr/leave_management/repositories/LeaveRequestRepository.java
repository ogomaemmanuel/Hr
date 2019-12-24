package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    @Query("Select le from LeaveRequest le where le.applicantId=?#{ principal?.id }")
    public Page<LeaveRequest> findCurrentUserLeaveRequest(Pageable pageable);

    @Query(value = "select s.user_id as userId,s.id as staffId,concat_ws(u.first_name,u.last_name) as fullName from staffs s left join users u on s.user_id=u.id where s.user_id!=?#{principal.id}", nativeQuery = true)
    public List<Map<String, String>> getInplaceEmployeeSelectList();

    @Query(value = "select lt.id, lt.name as leaveType,lt.number_of_days as elligibleDays," +
            "(select sum(lr.number_of_days) from leave_requests lr where lr.leave_type_id=lt.id and " +
            "lr.applicant_user_id=?#{ principal?.id }) as totalDaysApplied " +
            " from  leave_types lt", nativeQuery = true)
    public List<Map<String, String>> findCurrentUserLeaveBalances();
}
