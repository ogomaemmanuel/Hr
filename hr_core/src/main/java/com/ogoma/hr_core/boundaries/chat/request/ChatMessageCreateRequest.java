package com.ogoma.hr_core.boundaries.chat.request;

import com.ogoma.hr_core.boundaries.chat.entities.ChatMessage;

public class ChatMessageCreateRequest {
    private String message;
    private Long recipient;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getRecipient() {
        return recipient;
    }

    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }

}
