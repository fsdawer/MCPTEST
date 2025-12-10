package aaa.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "chat_message")
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(nullable = false)
    private Long roomId;

    @Enumerated(EnumType.STRING)
    private MessageType messageType; // 메시지 타입 (ENTER, TALK)

    @Column(name = "sender", length = 50, nullable = false)
    private String sender;

    @Column(nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false, updatable = false) // 3. DB 컬럼명(created_at)과 매칭
    @CreationTimestamp
    private LocalDateTime created;


    @Builder
    public ChatMessage(Long roomId, MessageType messageType, String sender, String message) {
        this.roomId = roomId;
        this.messageType = messageType;
        this.sender = sender;
        this.message = message;
    }
}
