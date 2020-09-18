package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ClientProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ClientViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ClientsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import nl.martijndwars.webpush.cli.Cli;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientsRepository clientsRepository;

    public ClientService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public Client createClient(Client client) {
        client = this.clientsRepository.save(client);
        return client;
    }

    public Page<ClientViewModel> getClients(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<ClientViewModel> clients =
                this.clientsRepository.findAllClients(pageRequest);
        return clients;

    }


    public Optional<ClientProjection> getClientById(Long clientId) {
        Optional<ClientProjection> client = this.clientsRepository.findClientById(clientId);
        return client;
    }

    public void removeClient(Long clientId) {
        this.clientsRepository.deleteById(clientId);
    }

    public Optional<Client> updateClient(Long clientId, Client client) {
        Optional<Client> optionalClient =
                this.clientsRepository.findById(clientId);
        optionalClient.ifPresent(c -> {
            c.setCompanyName(client.getCompanyName());
            c.setDescription(client.getDescription());
            User user = c.getUser();
            user.setEmail(client.getUser().getEmail());
            user.setFirstName(client.getUser().getFirstName());
            user.setLastName(client.getUser().getLastName());
            user.setPhone(client.getUser().getPhone());
            this.clientsRepository.save(c);
        });
        return optionalClient;
    }
}
