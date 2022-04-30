package com.ogoma.vue_starter.vue_starter.boundaries.address_book.services;

import com.ogoma.vue_starter.vue_starter.boundaries.address_book.entities.AddressBookContact;
import com.ogoma.vue_starter.vue_starter.boundaries.address_book.repository.AddressBookContactRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.address_book.requests.AddressBookContactCreateRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookContactService {
    private final AddressBookContactRepository addressBookContactRepository;

    public AddressBookContactService(AddressBookContactRepository addressBookContactRepository) {
        this.addressBookContactRepository = addressBookContactRepository;
    }

    public AddressBookContact createAddressBookContact(AddressBookContactCreateRequest addressBookContactCreateRequest) {
        AddressBookContact addressBookContact = new AddressBookContact();
        convertToEntity(addressBookContact, addressBookContactCreateRequest);
        this.addressBookContactRepository.save(addressBookContact);
        return addressBookContact;
    }

    public List<AddressBookContact> getAllAddressBookContacts() {
        List<AddressBookContact> addressBookContacts = this.addressBookContactRepository.findAll();
        return addressBookContacts;
    }

    public Page<AddressBookContact> getAddressBookContactsPaged(PagedDataRequest pagedDataRequest) {
        Page<AddressBookContact> addressBookContacts =
                this.addressBookContactRepository.findAll(pagedDataRequest.toPageable());
        return addressBookContacts;
    }

    public Optional<AddressBookContact> updateAddressBookContact(Long id
            , AddressBookContactCreateRequest addressBookContactCreateRequest) {
        Optional<AddressBookContact> addressBookContact =
                this.addressBookContactRepository.findById(id);
        addressBookContact.ifPresent(adBookC -> {
            convertToEntity(adBookC, addressBookContactCreateRequest);
        });
        return addressBookContact;
    }

    public Optional<AddressBookContact> getAddressBookContactByID(Long id) {
        Optional<AddressBookContact> addressBookContact =
                this.addressBookContactRepository.findById(id);
        return addressBookContact;
    }

    private void convertToEntity(AddressBookContact addressBookContact,
                                 AddressBookContactCreateRequest addressBookContactCreateRequest) {
        addressBookContact.setEmail(addressBookContactCreateRequest.getEmail());
        addressBookContact.setPhoneNo(addressBookContactCreateRequest.getPhoneNo());
        addressBookContact.setName(addressBookContactCreateRequest.getName());
    }


    public void removeContact(Long id) {
        this.addressBookContactRepository.deleteById(id);
    }
}
