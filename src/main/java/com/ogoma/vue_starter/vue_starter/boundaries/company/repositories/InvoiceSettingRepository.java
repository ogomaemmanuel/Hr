package com.ogoma.vue_starter.vue_starter.boundaries.company.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.InvoiceSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceSettingRepository extends JpaRepository<InvoiceSetting,Long> {

}
