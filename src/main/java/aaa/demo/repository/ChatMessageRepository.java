package aaa.demo.repository;

import aaa.demo.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<ChatRoom, Long> = <엔티티, ID타입>
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    // repository는 타입을 엔티티에 있는 타입으로 받아야함
    List<ChatMessage> findByRoomId(Long roomId);

}
