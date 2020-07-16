package com.ogoma.vue_starter.vue_starter.seeders;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Permission;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PermissionsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminationReason;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminationReasonsRepository;
import com.ogoma.vue_starter.vue_starter.entities.FamilyRelationship;
import com.ogoma.vue_starter.vue_starter.entities.MaritalStatus;
import com.ogoma.vue_starter.vue_starter.repositories.FamilyRelationshipRepository;
import com.ogoma.vue_starter.vue_starter.repositories.MaritalStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Profile(value = {"dev", "development", "test", "staging", "demo"})
public class DatabaseSeeder implements CommandLineRunner {
    private final MaritalStatusRepository maritalStatusRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final PermissionsRepository permissionsRepository;
    private final UsersRepository usersRepository;
    private final TerminationReasonsRepository terminationReasonsRepository;

    public DatabaseSeeder(MaritalStatusRepository maritalStatusRepository, FamilyRelationshipRepository familyRelationshipRepository, PermissionsRepository permissionsRepository, UsersRepository usersRepository, TerminationReasonsRepository terminationReasonsRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.permissionsRepository = permissionsRepository;
        this.usersRepository = usersRepository;
        this.terminationReasonsRepository = terminationReasonsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedUsers();
        seedMaritalStatus();
        seedFamilyRelationship();
        seedPermissions();
        seedTerminationReasons();
    }

    public void seedUsers() {
        if (this.usersRepository.count() == 0) {
            User user = new User();
            user.setFirstName("admin");
            user.setLastName("test");
            user.setEmail("testadmin@gmail.com");
            user.setIdentityNo("5666565656");
            user.setPhone("8888888888");
            user.setDateOfBirth(Date.from(Instant.now()));
            user.setIdentityNo("5666565656");
            user.setPassword("test@123");
            User user2 = new User();
            user2.setFirstName("User");
            user2.setLastName("user");
            user2.setEmail("testuser@gmail.com");
            user2.setIdentityNo("999999999");
            user2.setPhone("90000000");
            user2.setDateOfBirth(Date.from(Instant.now()));
            user2.setIdentityNo("3435353535");
            user2.setPassword("test@123");
            List<User> arrayList = new ArrayList();
            arrayList.add(user);
            arrayList.add(user2);
            this.usersRepository.saveAll(arrayList);
        }
    }

    public void seedMaritalStatus() {
        if (this.maritalStatusRepository.count() == 0) {
            List<MaritalStatus> maritalStatuses = new ArrayList<>();
            maritalStatuses.add(new MaritalStatus("single", MaritalStatus.SINGLE));
            maritalStatuses.add(new MaritalStatus("Married", MaritalStatus.MARRIED));
            maritalStatuses.add(new MaritalStatus("Widowed", MaritalStatus.WIDOWED));
            maritalStatuses.add(new MaritalStatus("Separated", MaritalStatus.SEPARATED));
            maritalStatuses.add(new MaritalStatus("Divorced", MaritalStatus.DIVORCED));
            this.maritalStatusRepository.saveAll(maritalStatuses);
        }
    }

    public void seedFamilyRelationship() {
        if (this.familyRelationshipRepository.count() == 0) {
            List<FamilyRelationship> familyRelationships = new ArrayList<>();
            familyRelationships.add(new FamilyRelationship("Father"));
            familyRelationships.add(new FamilyRelationship("Sister"));
            familyRelationships.add(new FamilyRelationship("Mother"));
            familyRelationships.add(new FamilyRelationship("Brother"));
            familyRelationships.add(new FamilyRelationship("Cousin"));
            familyRelationships.add(new FamilyRelationship("Mother In Law"));
            familyRelationships.add(new FamilyRelationship("Father In Law"));
            familyRelationships.add(new FamilyRelationship("Son"));
            familyRelationships.add(new FamilyRelationship("Daughter"));
            this.familyRelationshipRepository.saveAll(familyRelationships);
        }
    }

    public void seedPermissions() {
        if (this.permissionsRepository.count() == 0) {
            List<Permission> permissionList = new ArrayList<>();
            permissionList.add(new Permission("Create User"));
            permissionList.add(new Permission("Delete User"));
            permissionList.add(new Permission("Update User"));
            permissionList.add(new Permission("View User"));
            permissionList.add(new Permission("Export User Report"));
            this.permissionsRepository.saveAll(permissionList);
        }
    }

    public void seedTerminationReasons() {
        TerminationReason terminationReason = new TerminationReason("Misconduct");
        this.terminationReasonsRepository.save(terminationReason);
    }
}
