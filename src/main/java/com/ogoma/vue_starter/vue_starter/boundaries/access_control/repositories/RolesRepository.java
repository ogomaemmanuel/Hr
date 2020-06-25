package com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

    Page<Role> findAllByDeletedFalse(Pageable pageable);
}
