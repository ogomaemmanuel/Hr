package com.ogoma.hr_core.boundaries.access_control.repositories;

import com.ogoma.hr_core.boundaries.access_control.entities.FamilyMember;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FamilyMemberRepository extends BaseRepo<FamilyMember>{
    List<FamilyMember> findByPhoneNumberAndUserId(String phone, Long userId);
    
    @Query(value = "select m.id, m.name, m.phone_number phoneNumber, m.relationship_id relationshipId, m.user_id userId, " +
            "date_format(m.dob, '%Y-%m-%d') as dob, r.name relationship from family_members m left join family_relationships r on r.id = m.relationship_id where user_id = :userId"
            ,nativeQuery = true)
    List<Map<String,String>> findByUserId(Long userId);
}
