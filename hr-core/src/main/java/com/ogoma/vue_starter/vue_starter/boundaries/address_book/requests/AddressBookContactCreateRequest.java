package com.ogoma.vue_starter.vue_starter.boundaries.address_book.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.address_book.entities.AddressBookContact;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AddressBookContactCreateRequest {
    private String name;
    private String email;
    private String phoneNo;
    @Enumerated(EnumType.STRING)
    private AddressBookContact.Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public AddressBookContact.Type getType() {
        return type;
    }

    public void setType(AddressBookContact.Type type) {
        this.type = type;
    }
}
