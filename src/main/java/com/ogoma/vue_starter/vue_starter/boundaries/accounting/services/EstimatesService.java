package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.EstimatesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ClientsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ProjectsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import nl.martijndwars.webpush.cli.Cli;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Page<EstimateProjection> getEstimates(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<EstimateProjection> estimates =
                this.estimatesRepository.getEstimates(pageRequest);
        return estimates;
    }

    public Optional<Estimate> getEstimateById(Long id) {
        Optional<Estimate> estimate =
                this.estimatesRepository.findById(id);
        return estimate;
    }

    public Estimate createEstimate(EstimateRequest estimateRequest) {
        Estimate estimate = new Estimate();
        Client client = this.clientsRepository.findById(estimateRequest.getClientId()).orElseThrow(() -> {
            return new RuntimeException();
        });
        //Project project =
        estimate.setItems(estimate.getItems());
        estimate.setEstimateDate(estimateRequest.getEstimateDate());
        estimate.setClient(client);
        //estimate.setAmount(estimateRequest.get());
        estimate.setExpiryDate(estimateRequest.getExpiryDate());
        estimate.setOtherInformation(estimateRequest.getOtherInformation());
        this.estimatesRepository.save(estimate);
        return estimate;
    }

    public Optional<Estimate> updateEstimate(Long id, EstimateRequest estimateRequest) {
        Optional<Estimate> estimate = this.estimatesRepository.findById(id);
        estimate.ifPresent(e -> {

        });
        return estimate;
    }

    public void removeEstimateById(Long id) {
        this.estimatesRepository.deleteById(id);
    }
}
