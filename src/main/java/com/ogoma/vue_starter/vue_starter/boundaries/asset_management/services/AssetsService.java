package com.ogoma.vue_starter.vue_starter.boundaries.asset_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.repositories.AssetsRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;
    public AssetsService(AssetsRepository assetsRepository) {
        this.assetsRepository = assetsRepository;
    }



}
