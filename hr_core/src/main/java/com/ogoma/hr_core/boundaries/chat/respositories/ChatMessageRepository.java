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

    @Query(value = "select  c from ChatMessage c left join  fetch c.sender left join  fetch c.recipient where (c.sender.id=:userOneId and c.recipient.id=:userTwoId) or (c.sender.id=:userTwoId and c.recipient.id=:userOneId) order by c.createdAt desc "
    ,countQuery = "select  count(c) from ChatMessage c where (c.sender.id=:userOneId and c.recipient.id=:userTwoId) or (c.sender.id=:userTwoId and c.recipient.id=:userOneId)"
    )
    public Page<ChatMessage> getUserMessage(Long userOneId, Long userTwoId, Pageable pageable);


    @Query(value = """
            select u.first_name as firstName,u.last_name as lastName,cm.message as lastMessage, u.id as userId from users u left join 
            (select case when sender_id=:userId then recipient_id else sender_id end as user_id,cm.message,cm.created_at from chat_messages cm where (sender_id=:userId or recipient_id=:userId) and created_at=(select max(created_at) from chat_messages where (sender_id=cm.sender_id and recipient_id=cm.recipient_id) or (sender_id=cm.recipient_id and recipient_id=cm.sender_id) ) order by created_at desc) cm on cm.user_id=u.id where u.id!=:userId order by cm.created_at desc
            """, nativeQuery = true)
    public Page<ChatConversationsProjection> getUserConversations(Long userId, Pageable pageable);
}
