package com.ogoma.vue_starter.vue_starter.boundaries.asset_management;

import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.entities.Asset;
import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.requests.AssetRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.services.AssetsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AssetController {
    private final AssetsService assetsService;

    public AssetController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @RequestMapping(value = "api/assets", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAssets(PagedDataRequest pagedDataRequest) {
        Page<Asset> assets =
                this.assetsService.getAllAssets(pagedDataRequest);
        return ResponseEntity.ok(assets);
    }

    @RequestMapping(value = "api/assets/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAssetById(@PathVariable Long id) {
        Optional<Asset> asset = this.assetsService.getAssetById(id);
        return ResponseEntity.of(asset);
    }

    @RequestMapping(value = "api/assets", method = RequestMethod.POST)
    public ResponseEntity<?> createAsset(@RequestBody @Valid AssetRequest assetRequest) {
        Asset asset = this.assetsService.createAsset(assetRequest);
        return ResponseEntity.ok(asset);
    }

    @RequestMapping(value = "api/assets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAsset(@PathVariable Long id) {
        this.assetsService.removeAsset(id);
        return ResponseEntity.ok("Asset successfully removed");
    }
    @RequestMapping(value = "api/assets/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAsset(@PathVariable Long id, @RequestBody @Valid AssetRequest assetRequest) {
        Optional<Asset> asset = this.assetsService.updateAsset(id, assetRequest);
        return ResponseEntity.of(asset);
    }


}
