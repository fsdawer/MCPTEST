package aaa.demo.dto;


import aaa.demo.entity.ChatMessage;
import aaa.demo.entity.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessageDto {
    private Long messageId;
    private Long roomId;
    private String message;
    private String sender;
    private MessageType type;
    private String createdTime;



    // (DTO -> Entity 변환)
    public ChatMessage toEntity() {
        return ChatMessage.builder() // 엔티티에 있는 @Builder를 여기서 호출!
                .roomId(this.roomId)
                .messageType(this.type)
                .sender(this.sender)
                .message(this.message)
                .build();
    }


    // Entity -> DTO 변환 메서드
    public static ChatMessageDto from(ChatMessage chatMessage) {
        ChatMessageDto chatMessageDto = new ChatMessageDto();
        chatMessageDto.setRoomId(chatMessage.getRoomId());
        chatMessageDto.setSender(chatMessage.getSender());
        chatMessageDto.setMessage(chatMessage.getMessage());
        chatMessageDto.setType(chatMessage.getMessageType());

        return chatMessageDto;
    }

}
