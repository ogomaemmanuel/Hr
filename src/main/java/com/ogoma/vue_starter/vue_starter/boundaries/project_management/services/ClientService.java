package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
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

    public Page<Client> getClients(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<Client> clients =
                this.clientsRepository.findAll(pageRequest);
        return clients;

    }


    public Optional<Client> getClientById(Long clientId) {
        Optional<Client> client = this.clientsRepository.findById(clientId);
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
            c.setUser(client.getUser());
            this.clientsRepository.save(c);
        });
        return optionalClient;
    }
}
