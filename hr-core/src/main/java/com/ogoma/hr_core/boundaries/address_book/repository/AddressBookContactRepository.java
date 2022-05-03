package com.ogoma.vue_starter.vue_starter.boundaries.address_book.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.address_book.entities.AddressBookContact;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookContactRepository extends BaseRepo<AddressBookContact> {
    List<AddressBookContact> findAllByCreatedById(Long id);
    List<AddressBookContact> findAllByCreatedBy(User user);
}
