package com.ogoma.vue_starter.vue_starter.boundaries.banks.services;

import com.ogoma.vue_starter.vue_starter.boundaries.banks.entities.Bank;
import com.ogoma.vue_starter.vue_starter.boundaries.banks.repositories.BanksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanksService {
    private final BanksRepository banksRepository;

    public BanksService(BanksRepository banksRepository) {
        this.banksRepository = banksRepository;
    }

    public List<Bank> getBanks() {
        List<Bank> banks = this.banksRepository.findAll();
        return banks;
    }

    public Bank createBank(Bank bank) {
        this.banksRepository.save(bank);
        return bank;
    }

}
