package com.ogoma.hr_core.boundaries.access_control.repositories;

import com.ogoma.hr_core.boundaries.access_control.entities.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Long>, JpaSpecificationExecutor<EmergencyContact> {

    @Query(value = "select ec.id, ec.user_id userId, ec.primary_name primaryName, ec.primary_phone_one primaryPhoneOne, ec.primary_phone_two primaryPhoneTwo, " +
            "ec.primary_relationship primaryRelationship, ec.secondary_name secondaryName, ec.secondary_phone_one secondaryPhoneOne, ec.secondary_phone_two secondaryPhoneTwo, " +
            "ec.secondary_relationship secondaryRelationship from emergency_contacts ec where ec.user_id = :userId",nativeQuery = true)
    List<Map<String,String>> findAllContactsByUserId(Long userId);

    EmergencyContact findByUserId(Long userId);
}
