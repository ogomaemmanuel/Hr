package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Client,Long> {
}
