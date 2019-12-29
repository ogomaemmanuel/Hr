package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveRequestHistory,Long> {

}
