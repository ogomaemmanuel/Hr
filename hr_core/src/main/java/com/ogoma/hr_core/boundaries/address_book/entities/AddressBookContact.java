package com.ogoma.hr_core.boundaries.address_book.entities;

import com.ogoma.hr_core.boundaries.access_control.entities.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address_book_contacts")
public class AddressBookContact {
    public enum Type {
        COMPANY, CLIENT, STAFF, PERSONAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNo;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private User createdBy;
    private Date createdAt;
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
