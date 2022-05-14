package com.ogoma.hr_core.boundaries.chat;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messageSender;

    public ChatController(SimpMessagingTemplate messageSender) {
        this.messageSender = messageSender;
    }


}
