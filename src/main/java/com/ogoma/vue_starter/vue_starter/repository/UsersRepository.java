package com.ogoma.vue_starter.vue_starter.repository;

import com.ogoma.vue_starter.vue_starter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
    @Nullable
    User findByEmail(String email);
}
