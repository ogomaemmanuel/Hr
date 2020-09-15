package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ClientsController {
    private final ClientService clientService;

    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "api/clients", method = RequestMethod.POST)
    public ResponseEntity<?> saveClient(@RequestBody @Valid Client client) {
        client = this.clientService.createClient(client);
        return ResponseEntity.ok(client);
    }
}
