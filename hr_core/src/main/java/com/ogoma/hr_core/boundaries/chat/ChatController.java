package com.ogoma.hr_core.boundaries.chat;

import com.ogoma.hr_core.boundaries.chat.entities.ChatMessage;
import com.ogoma.hr_core.boundaries.chat.request.ChatMessageCreateRequest;
import com.ogoma.hr_core.boundaries.chat.responses.ChatMessageResponse;
import com.ogoma.hr_core.boundaries.chat.services.ChatMessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chats")
public class ChatController {
    private final SimpMessagingTemplate messageSender;
    private final ChatMessageService chatMessageService;

    public ChatController(SimpMessagingTemplate messageSender, ChatMessageService chatMessageService) {
        this.messageSender = messageSender;
        this.chatMessageService = chatMessageService;
    }

    @PostMapping
    public ResponseEntity<?> createChatMessage(@RequestBody ChatMessageCreateRequest createRequest) {
        ChatMessage message = this.chatMessageService.createMessage(createRequest);
        var response = new ChatMessageResponse(message.getMessage(), message.getSender().getId(), message.getRecipient().getId(), "");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{otherUserId}")
    public ResponseEntity<?> getConversationMessages(@PathVariable Long otherUserId, Pageable pageable) {
        Page<ChatMessage> chatMessagePage =
                this.chatMessageService.getCurrentUserConversationMessages(otherUserId, pageable);
        return ResponseEntity.ok(chatMessagePage);
    }

    @GetMapping(value = "/conversations")
    public ResponseEntity<?> getConversations(Pageable pageable) {
        var result = this.chatMessageService.getUserConversations(pageable);
        return ResponseEntity.ok(result);
    }


}
