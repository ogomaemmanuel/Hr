package com.ogoma.hr_core.boundaries.address_book;

import com.ogoma.hr_core.boundaries.address_book.entities.AddressBookContact;
import com.ogoma.hr_core.boundaries.address_book.requests.AddressBookContactCreateRequest;
import com.ogoma.hr_core.boundaries.address_book.services.AddressBookContactService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/address-book")
public class AddressBookContactController {
    private final AddressBookContactService addressBookContactService;

    public AddressBookContactController(AddressBookContactService addressBookContactService) {
        this.addressBookContactService = addressBookContactService;
    }

    @GetMapping
    public ResponseEntity getContacts(PagedDataRequest pagedDataRequest) {
        Page<AddressBookContact> addressBookContacts =
                this.addressBookContactService.getAddressBookContactsPaged(pagedDataRequest);
        return ResponseEntity.ok(addressBookContacts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id) {
        Optional<AddressBookContact> addressBookContact = this.addressBookContactService.getAddressBookContactByID(id);
        return ResponseEntity.of(addressBookContact);
    }

    @PostMapping
    public ResponseEntity<?> createContact(
            @Valid @RequestBody AddressBookContactCreateRequest contactCreateRequest) {
        AddressBookContact addressBookContact =
                this.addressBookContactService.createAddressBookContact(contactCreateRequest);
        return ResponseEntity.ok(addressBookContact);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody
            AddressBookContactCreateRequest contactCreateRequest) {
        Optional<AddressBookContact> addressBookContact =
                this.addressBookContactService.updateAddressBookContact(id, contactCreateRequest);
        return ResponseEntity.ok(addressBookContact);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeContact(@PathVariable Long id) {
        this.addressBookContactService.removeContact(id);
        return ResponseEntity.noContent().build();
    }
}

