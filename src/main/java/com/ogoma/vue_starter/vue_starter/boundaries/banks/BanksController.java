package com.ogoma.vue_starter.vue_starter.boundaries.banks;

import com.ogoma.vue_starter.vue_starter.boundaries.banks.entities.Bank;
import com.ogoma.vue_starter.vue_starter.boundaries.banks.services.BanksService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Bank> banks = this.banksService.getBanks();
        return ResponseEntity.ok(banks);
    }
}
