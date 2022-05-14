package com.ogoma.hr_core.boundaries.banks.repositories;

import com.ogoma.hr_core.boundaries.banks.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanksRepository extends JpaRepository<Bank,Long> {

}
