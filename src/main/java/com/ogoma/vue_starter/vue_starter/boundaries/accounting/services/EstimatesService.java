package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.EstimateItem;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimatePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.EstimatesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.specifications.EstimatesSpecification;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ClientsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ProjectsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import nl.martijndwars.webpush.cli.Cli;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstimatesService {
    private final EstimatesRepository estimatesRepository;
    private final ClientsRepository clientsRepository;
    private final ProjectsRepository projectsRepository;

    public EstimatesService(EstimatesRepository estimatesRepository,
                            ClientsRepository clientsRepository,
                            ProjectsRepository projectsRepository
    ) {
        this.estimatesRepository = estimatesRepository;
        this.clientsRepository = clientsRepository;
        this.projectsRepository = projectsRepository;
    }

    public Page<Estimate> getEstimates(EstimatePagedDataRequest pagedDataRequest) {
        Page<Estimate> estimates =
                this.estimatesRepository.findAll(pagedDataRequest.getSpecification(), pagedDataRequest.toPageable());
        return estimates;
    }

    public Optional<Estimate> getEstimateById(Long id) {
        Optional<Estimate> estimate =
                this.estimatesRepository.fetchEstimateById(id);
        return estimate;
    }

    public Estimate createEstimate(EstimateRequest estimateRequest) {
        Estimate estimate = new Estimate();
        Client client = this.clientsRepository.getOne(estimateRequest.getClientId());
        List<EstimateItem> estimateItems=
                estimateRequest.getItems().stream().map(x->{
                  EstimateItem item=  new EstimateItem();
                  item.setName(x.getName());
                  item.setDescription(x.getDescription());
                  item.setQuantity(x.getQuantity());
                  item.setUnitCost(x.getUnitCost());
                  return item;
                }).collect(Collectors.toList());
        //Project project =
        estimate.setItems(estimateItems);
        estimate.setEstimateDate(estimateRequest.getEstimateDate());
        estimate.setClient(client);
        estimate.setAmount(estimateRequest.getAmount());
        estimate.setExpiryDate(estimateRequest.getExpiryDate());
        estimate.setOtherInformation(estimateRequest.getOtherInformation());
        this.estimatesRepository.save(estimate);
        if(estimateRequest.isSaveAndSend()){
            //TODO send email to client asynchronously
        }
        return estimate;
    }

    public Optional<Estimate> updateEstimate(Long id, EstimateRequest estimateRequest) {
        Optional<Estimate> estimate = this.estimatesRepository.findById(id);
        estimate.ifPresent(e -> {
            e.setAmount(estimateRequest.getAmount());
            e.setEstimateDate(e.getEstimateDate());
            e.setExpiryDate(estimateRequest.getExpiryDate());
            this.estimatesRepository.save(e);
            //ToDO add estimate items
        });
        return estimate;
    }

    public void removeEstimateById(Long id) {
        this.estimatesRepository.deleteById(id);
    }
}
