package com.ogoma.hr_core.boundaries.address_book.repository;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.address_book.entities.AddressBookContact;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookContactRepository extends BaseRepo<AddressBookContact> {
    List<AddressBookContact> findAllByCreatedById(Long id);
    List<AddressBookContact> findAllByCreatedBy(User user);
}
