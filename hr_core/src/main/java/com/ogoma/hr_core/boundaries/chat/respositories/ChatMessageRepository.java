package com.ogoma.hr_core.boundaries.chat.respositories;

import com.ogoma.hr_core.boundaries.chat.entities.ChatMessage;
import com.ogoma.hr_core.boundaries.chat.projections.ChatConversationsProjection;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends BaseRepo<ChatMessage> {

    @Query(value = "select  c from ChatMessage c left join  fetch c.sender left join  fetch c.recipient where (c.sender.id=:userOneId and c.recipient.id=:userTwoId) or (c.sender.id=:userTwoId and c.recipient.id=:userOneId)"
    ,countQuery = "select  count(c) from ChatMessage c where (c.sender.id=:userOneId and c.recipient.id=:userTwoId) or (c.sender.id=:userTwoId and c.recipient.id=:userOneId)"
    )
    public Page<ChatMessage> getUserMessage(Long userOneId, Long userTwoId, Pageable pageable);


    @Query(value = """
            select cm.message as lastChatMessage,cm.created_at as lastChatTime, u.first_name as firstName, u.id as userId   from users u left join (
            select coalesce(sender_id,recipient_id) as user_id, message, created_at from chat_messages  cm where (cm.sender_id=:userId or cm.recipient_id=:userId) and(sender_id is not null or recipient_id is not null )
            order by created_at desc limit 1
            ) cm on cm.user_id=u.id where u.id!=:userId
            """, nativeQuery = true)
    public Page<ChatConversationsProjection> getUserConversations(Long userId, Pageable pageable);
}
