package com.ogoma.hr_core.boundaries.banks;

import com.ogoma.hr_core.boundaries.banks.entities.Bank;
import com.ogoma.hr_core.boundaries.banks.services.BanksService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/banks")
public class BanksController {
    private final BanksService banksService;

    public BanksController(BanksService banksService) {
        this.banksService = banksService;
    }

    @GetMapping
    public ResponseEntity<?> getBanks() {
        List<Bank> bankList = new ArrayList<>();
        List<Bank> banks = this.banksService.getBanks();
        for(Bank bank: banks){
            int branchCount = bank.getBranches().size();
            bankList.add(bank);
        }
        return ResponseEntity.ok(bankList);
    }
}
