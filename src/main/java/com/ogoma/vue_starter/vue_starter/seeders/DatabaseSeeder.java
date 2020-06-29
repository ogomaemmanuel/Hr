package com.ogoma.vue_starter.vue_starter.seeders;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Permission;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PermissionsRepository;
import com.ogoma.vue_starter.vue_starter.entities.FamilyRelationship;
import com.ogoma.vue_starter.vue_starter.entities.MaritalStatus;
import com.ogoma.vue_starter.vue_starter.repositories.FamilyRelationshipRepository;
import com.ogoma.vue_starter.vue_starter.repositories.MaritalStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile(value = {"dev", "development", "test", "staging", "demo"})
public class DatabaseSeeder implements CommandLineRunner {
    private final MaritalStatusRepository maritalStatusRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final PermissionsRepository permissionsRepository;

    public DatabaseSeeder(MaritalStatusRepository maritalStatusRepository, FamilyRelationshipRepository familyRelationshipRepository, PermissionsRepository permissionsRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.permissionsRepository = permissionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedMaritalStatus();
        seedFamilyRelationship();
        seedPermissions();
    }

    public void seedMaritalStatus() {
        if (this.maritalStatusRepository.count() == 0) {
            List<MaritalStatus> maritalStatuses = new ArrayList<>();
            maritalStatuses.add(new MaritalStatus("single", "S"));
            maritalStatuses.add(new MaritalStatus("Married", "M"));
            maritalStatuses.add(new MaritalStatus("Widowed", "W"));
            maritalStatuses.add(new MaritalStatus("Separated", "SP"));
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
}
