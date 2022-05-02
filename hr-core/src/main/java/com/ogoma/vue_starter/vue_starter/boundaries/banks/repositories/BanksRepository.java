package com.ogoma.vue_starter.vue_starter.boundaries.banks.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.banks.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanksRepository extends JpaRepository<Bank,Long> {

}
