package aaa.demo.repository;

import aaa.demo.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<ChatRoom, Long> = <엔티티, ID타입>
@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    // Repository는 타입을 엔티티에 있는 타입으로 받아야함
    ChatRoom findByRoomName(String roomName);
}
