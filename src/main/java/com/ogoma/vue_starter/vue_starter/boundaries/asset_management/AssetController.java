package com.ogoma.vue_starter.vue_starter.boundaries.asset_management;

import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.services.AssetsService;
import org.springframework.stereotype.Controller;

@Controller
public class AssetController {
    private final AssetsService assetsService;
    public AssetController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }
}
