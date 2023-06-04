package com.ogoma.hr_core.boundaries.chat.services;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.hr_core.boundaries.chat.entities.ChatMessage;
import com.ogoma.hr_core.boundaries.chat.projections.ChatConversationsProjection;
import com.ogoma.hr_core.boundaries.chat.request.ChatMessageCreateRequest;
import com.ogoma.hr_core.boundaries.chat.responses.ChatMessageResponse;
import com.ogoma.hr_core.boundaries.chat.respositories.ChatMessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final UsersRepository usersRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, SimpMessagingTemplate messageSender, SimpMessagingTemplate simpMessagingTemplate, UsersRepository usersRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;

        this.usersRepository = usersRepository;
    }

    public ChatMessage createMessage(ChatMessageCreateRequest chatMessageCreateRequest) {
        User recipient = usersRepository.getReferenceById(chatMessageCreateRequest.getRecipient());
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRecipient(recipient);
        chatMessage.setMessage(chatMessageCreateRequest.getMessage());
        chatMessage.setSender(userDetails.getUser());
        this.chatMessageRepository.save(chatMessage);
      var notification=  new ChatMessageResponse(chatMessage.getMessage(), chatMessage.getSender().getId(), chatMessage.getRecipient().getId(), "");
        this.simpMessagingTemplate.convertAndSendToUser(chatMessage.getRecipient().getEmail(),"",notification);
        return chatMessage;
    }
    public Page<ChatMessage> getCurrentUserConversationMessages(Long otherUserId, Pageable pageable) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<ChatMessage> chatMessagePage = this.chatMessageRepository.getUserMessage(userDetails.getUser().getId(), otherUserId, pageable);
        return chatMessagePage;
    }

    public Page<ChatConversationsProjection> getUserConversations(Pageable pageable){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<ChatConversationsProjection> chatMessagePage = this.chatMessageRepository.getUserConversations(userDetails.getUser().getId(),pageable);
        return  chatMessagePage;
    }
}
