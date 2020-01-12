package com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.PasswordReset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset,Long> {

    @Nullable
    PasswordReset findByToken(String token);
}
