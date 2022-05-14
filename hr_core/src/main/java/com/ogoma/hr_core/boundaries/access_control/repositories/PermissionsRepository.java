package com.ogoma.hr_core.boundaries.access_control.repositories;

import com.ogoma.hr_core.boundaries.access_control.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepository extends JpaRepository<Permission,Long> {
}
