package com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Long> {
}
