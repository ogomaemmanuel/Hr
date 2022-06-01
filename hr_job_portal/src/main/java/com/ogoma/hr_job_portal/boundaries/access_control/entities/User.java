package com.ogoma.hr_job_portal.boundaries.access_control.entities;

import com.ogoma.hr_job_portal.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {
    public enum Gender{
        MALE,FEMALE,OTHER
    }
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalIdNo;
    private String city;
    private String country;
    private String postalCode;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
