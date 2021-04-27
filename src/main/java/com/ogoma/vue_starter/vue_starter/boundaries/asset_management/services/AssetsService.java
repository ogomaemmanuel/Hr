package com.ogoma.vue_starter.vue_starter.boundaries.asset_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.entities.Asset;
import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.repositories.AssetsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.requests.AssetRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;
    private final UsersRepository usersRepository;

    public AssetsService(AssetsRepository assetsRepository,
                         UsersRepository usersRepository) {
        this.assetsRepository = assetsRepository;
        this.usersRepository = usersRepository;
    }

    public Page<Asset> getAllAssets(PagedDataRequest pagedDataRequest) {
        Page<Asset> assets = this.assetsRepository.findAll(pagedDataRequest.toPageable());
        return assets;
    }

    public Optional<Asset> getAssetById(Long id) {
        Optional<Asset> asset = this.assetsRepository.findById(id);
        return asset;
    }

    public Asset createAsset(AssetRequest assetRequest) {
        Asset asset = new Asset();
        this.setAssetDetails(asset,assetRequest);
        this.assetsRepository.save(asset);
        return asset;
    }

    public void removeAsset(Long id) {
        this.assetsRepository.deleteById(id);
    }

    public Optional<Asset>  updateAsset(Long id , AssetRequest assetRequest){
        Optional<Asset> asset = this.assetsRepository.findById(id);
        asset.ifPresent(a->{
            setAssetDetails(a,assetRequest);
            this.assetsRepository.save(a);
        });
      return asset;
    }
    private void setAssetDetails(Asset asset, AssetRequest assetRequest){
        asset.setDescription(assetRequest.getDescription());
        asset.setCondition(assetRequest.getCondition());
        asset.setStatus(assetRequest.getStatus());
        asset.setManufacturer(assetRequest.getManufacturer());
        asset.setPurchaseDate(assetRequest.getPurchaseDate());
        asset.setName(assetRequest.getName());
        asset.setSerialNumber(assetRequest.getSerialNumber());
        asset.setSupplier(assetRequest.getSupplier());
        asset.setValue(assetRequest.getValue());
        asset.setWarrantyInMonths(assetRequest.getWarrantyInMonths());
        asset.setPurchasedFrom(assetRequest.getPurchasedFrom());
    }
}
