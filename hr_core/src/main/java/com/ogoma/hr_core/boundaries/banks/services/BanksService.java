package com.ogoma.hr_core.boundaries.banks.services;

import com.ogoma.hr_core.boundaries.banks.entities.Bank;
import com.ogoma.hr_core.boundaries.banks.repositories.BanksRepository;
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

    public Bank createBankBranches(Bank bank) {
        this.banksRepository.save(bank);
        return bank;
    }

}
