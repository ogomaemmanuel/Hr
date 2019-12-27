package com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories;

import com.ogoma.vue_starter.vue_starter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
    @Nullable
    User findByEmail(String email);
    @Query(value = "SELECT u.* FROM users u left join staffs s on u.id=s.user_id where u.id=:id",nativeQuery = true)
    User findByStaffId(Long id);
}
