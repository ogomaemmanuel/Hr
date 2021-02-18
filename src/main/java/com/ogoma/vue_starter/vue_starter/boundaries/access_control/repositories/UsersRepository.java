package com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    @Nullable
    User findByEmail(String email);
    @Query(value = "SELECT u.* FROM users u left join employees s on u.id=s.user_id where s.id=:id",nativeQuery = true)
    User findByStaffId(Long id);
    @Query(value = "Select u From User u left join fetch Employee e",
            countQuery = "select count(u) from User u")
    Page<User> findAll(Pageable pageable);
}
