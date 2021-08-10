package com.ogoma.vue_starter.vue_starter.boundaries.chat;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messageSender;

    public ChatController(SimpMessagingTemplate messageSender) {
        this.messageSender = messageSender;
    }


}
