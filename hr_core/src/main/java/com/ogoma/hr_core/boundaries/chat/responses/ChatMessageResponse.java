package com.ogoma.hr_core.boundaries.chat.responses;

import java.time.LocalDateTime;

public record ChatMessageResponse(String message,
                                  Long messageId,
                                  Long senderId,
                                  Long  recipientId,
                                  LocalDateTime createdAt,
                                  String senderAvatarUrl) {
}
