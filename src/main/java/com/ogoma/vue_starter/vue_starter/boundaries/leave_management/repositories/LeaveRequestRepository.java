package com.ogoma.vue_starter.vue_starter.boundaries.leave_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.leave_management.entities.LeaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
    @Query("Select le from LeaveRequest le where le.applicantId=?#{ principal?.username }")
    public Page<LeaveRequest> findCurrentUserLeaveRequest(Pageable pageable);
}
