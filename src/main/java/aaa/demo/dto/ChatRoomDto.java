package aaa.demo.dto;

import aaa.demo.entity.ChatRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDto {

    private Long roomId;
    private String roomName;


    // (DTO -> Entity 변환)
    public ChatRoom toEntity() {
        return ChatRoom.builder()
                .roomName(this.roomName)
                .build();
    }


    //Entity -> DTO 변환 메서드
    public static ChatRoomDto from(ChatRoom chatRoom) {
        ChatRoomDto chatRoomDto = new ChatRoomDto();
        chatRoomDto.setRoomId(chatRoom.getRoomId());
        chatRoomDto.setRoomName(chatRoom.getRoomName());
        return chatRoomDto;
    }
}
