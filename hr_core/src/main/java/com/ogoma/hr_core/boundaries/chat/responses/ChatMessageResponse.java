package com.ogoma.hr_core.boundaries.chat.responses;

public record ChatMessageResponse(String message, Long senderId, Long  recipientId,String senderAvatarUrl) {
}
