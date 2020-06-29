package com.ogoma.vue_starter.vue_starter.seeders;

import com.ogoma.vue_starter.vue_starter.entities.MaritalStatus;
import com.ogoma.vue_starter.vue_starter.repositories.MaritalStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile(value = {"dev", "development", "test", "staging"})
public class DatabaseSeeder implements CommandLineRunner {
    private final MaritalStatusRepository maritalStatusRepository;

    public DatabaseSeeder(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedMaritalStatus();
    }

    public void seedMaritalStatus() {
        if (this.maritalStatusRepository.findAll().size() == 0) {
            List<MaritalStatus> maritalStatuses = new ArrayList<>();
            maritalStatuses.add(new MaritalStatus("single", "S"));
            maritalStatuses.add(new MaritalStatus("Married", "M"));
            maritalStatuses.add(new MaritalStatus("Widowed", "W"));
            maritalStatuses.add(new MaritalStatus("Separated", "SP"));
            this.maritalStatusRepository.saveAll(maritalStatuses);
        }
    }
}
