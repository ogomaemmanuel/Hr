package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveRequestHistory, Long> {
    @Query("select lh from LeaveRequestHistory lh left join fetch lh.leaveRequest left join fetch lh.user where lh.leaveRequest.id=:leaveRequestId")
    public List<LeaveRequestHistory> findAllByLeaveRequest_Id(Long leaveRequestId);
}
