package com.ogoma.hr_core.boundaries.hr.leave_management.repositories;

import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveHistoryRepository extends BaseRepo<LeaveRequestHistory> {
    @Query("select lh from LeaveRequestHistory lh left join fetch lh.leaveRequest left join fetch lh.user where lh.leaveRequest.id=:leaveRequestId")
    public List<LeaveRequestHistory> findAllByLeaveRequest_Id(Long leaveRequestId);
}
