package com.ogoma.hr_core.boundaries.hr.leave_management.repositories;

import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    @Query("Select le from LeaveRequest le where le.applicantId=?#{ principal?.id }")
    public Page<LeaveRequest> findCurrentUserLeaveRequest(Pageable pageable);

    @Query(value = "select s.id as userId,s.id as staffId,concat_ws(u.first_name,u.last_name) as fullName from employees s left join users u on s.id=u.id where s.id!=?#{principal.id}", nativeQuery = true)
    public List<Map<String, String>> getInplaceEmployeeSelectList();

    @Query(value = "select lt.id, lt.name as leaveType,lt.number_of_days as elligibleDays," +
            "(select sum(lr.number_of_days) from leave_requests lr where lr.leave_type_id=lt.id and " +
            "lr.applicant_user_id=?#{ principal?.id }) as totalDaysApplied " +
            " from  leave_types lt", nativeQuery = true)
    public List<Map<String, String>> findCurrentUserLeaveBalances();


    @Nullable
    @Query(value = "select (lt.number_of_days-coalesce(sum(lr.number_of_days),0)) leaveBalance from leave_requests lr left join leave_types lt on lr.leave_type_id=lt.id where lr.applicant_user_id=?#{ principal?.id } and lr.leave_type_id=?1 and year(now())=year(lr.created_at) group by leave_type_id", nativeQuery = true)
    public Long currentUserLeaveBalanceByLeaveTypeId(Long leaveTypeId);

    @Query(value = "Select le.id,le.start_date startDate,le.end_date endDate,le.number_of_days numberOfDays, le.leave_statuses status,lt.name  leaveType,CONCAT_WS(applicant.first_name,applicant.last_name) employee  from leave_requests le left join employees s on le.in_place=s.id left join leave_types  lt on le.leave_type_id=lt.id left join users applicant on le.applicant_user_id=applicant.id where le.leave_statuses in (?1) and s.id=?#{ principal?.id } and le.applicant_user_id !=?#{ principal?.id }",
            nativeQuery = true,
            countQuery = "Select le.* from leave_requests le left join employees s on le.in_place=s.id where le.leave_statuses in ?#{#leaveStatuses} and s.id=?#{ principal?.id } and le.applicant_user_id !=?#{ principal?.id }"
    )
    public Page<Map<String, String>> getLeaveRequestToApprove(List<String> leaveStatuses, Pageable pageable);

    @Query(value = "Select le.id,le.created_at as createdAt, le.start_date as startDate,le.end_date as endDate,le.number_of_days numberOfDays,lt.number_of_days as elligibleDays, le.leave_statuses status,lt.name  leaveType,CONCAT_WS(applicant.first_name,applicant.last_name) employee, " +
            " (select sum(lr.number_of_days) from leave_requests lr where lr.leave_type_id=lt.id and lr.applicant_user_id=le.applicant_user_id) as daysUsed from leave_requests le left join employees s on le.in_place=s.id left join leave_types  lt on le.leave_type_id=lt.id left join users applicant on le.applicant_user_id=applicant.id where le.id=:id", nativeQuery = true)
    public Map<String, String> findLeaveRequestDetailsByLeaveId(Long id);
}
