package com.ogoma.vue_starter.vue_starter.boundaries.company.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail,Long> {

}
