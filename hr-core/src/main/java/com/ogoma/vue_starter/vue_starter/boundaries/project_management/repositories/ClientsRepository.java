package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ClientProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ClientViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    @Query(value = "select c.id as id ,c.companyName as companyName ,c.description,c.user.firstName as firstName," +
            "c.user.lastName as lastName,c.user.phone as phone,c.user.email as email" +
            " from Client  c ")
    public Page<ClientViewModel> findAllClients(Pageable pageable);

   // @Query(value = "select c from Client c where c.id=:id")
    public Optional<ClientProjection> findClientById(Long id);
}
