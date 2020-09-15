package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.ClientService;
import org.springframework.stereotype.Controller;

@Controller
public class ClientsController {
    private final ClientService clientService;

    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }
}
