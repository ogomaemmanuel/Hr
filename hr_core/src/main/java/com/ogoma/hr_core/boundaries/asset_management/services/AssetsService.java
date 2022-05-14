package com.ogoma.hr_core.boundaries.asset_management.services;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.hr_core.boundaries.asset_management.entities.Asset;
import com.ogoma.hr_core.boundaries.asset_management.entities.Asset_;
import com.ogoma.hr_core.boundaries.asset_management.repositories.AssetsRepository;
import com.ogoma.hr_core.boundaries.asset_management.requests.AssetRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;
    private final UsersRepository usersRepository;
    private final SimpMessagingTemplate messageSender;

    public AssetsService(AssetsRepository assetsRepository,
                         UsersRepository usersRepository, SimpMessagingTemplate messageSender) {
        this.assetsRepository = assetsRepository;
        this.usersRepository = usersRepository;
        this.messageSender = messageSender;
    }

    public Page<Asset> getAllAssets(PagedDataRequest pagedDataRequest) {
        Page<Asset> assets =
                this.assetsRepository.findAll(
                        ((root, criteriaQuery, criteriaBuilder) -> {
                            if (Long.class != criteriaQuery.getResultType()) {
                                    root.fetch(Asset_.assetUser,JoinType.LEFT);
                            }
                            return criteriaBuilder.conjunction();
                        }),
                        pagedDataRequest.toPageable());
        return assets;
    }

    public Optional<Asset> getAssetById(Long id) {
        Optional<Asset> asset = this.assetsRepository.findById(id);
        return asset;
    }

    public Asset createAsset(AssetRequest assetRequest) {
        Asset asset = new Asset();
        this.setAssetDetails(asset, assetRequest);
        this.assetsRepository.save(asset);
        HashMap<String, Object> message = new HashMap<String,Object>();
        message.put("type","chat");
        message.put("body","Test");
        this.messageSender.convertAndSendToUser("testuser@gmail.com",
                "/queue/notifications",message);
        return asset;
    }

    public void removeAsset(Long id) {
        this.assetsRepository.deleteById(id);
    }

    public Optional<Asset> updateAsset(Long id, AssetRequest assetRequest) {
        Optional<Asset> asset = this.assetsRepository.findById(id);
        asset.ifPresent(a -> {
            setAssetDetails(a, assetRequest);
            this.assetsRepository.save(a);
        });
        return asset;
    }

    private void setAssetDetails(Asset asset, AssetRequest assetRequest) {
        if (assetRequest.getAssetUserId() != null) {
            User user = usersRepository.getOne(assetRequest.getAssetUserId());
            asset.setAssetUser(user);
        }
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
