package aaa.demo.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "chat_room")
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id") // 2. DB 컬럼명(room_id)과 매칭
    private Long roomId;

    @Column(name = "room_name", length = 100, nullable = false)
    private String roomName;

    @Column(name = "created_at", nullable = false, updatable = false) // 3. DB 컬럼명(created_at)과 매칭
    @CreationTimestamp
    private LocalDateTime created;


    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }


}
