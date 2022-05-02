package com.ogoma.vue_starter.vue_starter.boundaries.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ogoma.vue_starter.vue_starter.boundaries.chat.models.WebSocketMessage;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class SockJsController {
    @SubscribeMapping("/user-notifications-me")
    public String sendNotificationToUserOnSuccessLogin(
            Principal principal
    ) throws Exception {
        WebSocketMessage webSocketMessage = new WebSocketMessage();
        webSocketMessage.setType("EMAIL-VERIFICATION");
        webSocketMessage.setMessage("We noticed that you tried to change you email, Please verify your new email");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(webSocketMessage);
    }

}
