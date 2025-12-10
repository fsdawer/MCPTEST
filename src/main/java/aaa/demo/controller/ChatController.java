package aaa.demo.controller;

import aaa.demo.dto.ChatMessageDto;
import aaa.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    private final SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/chat/message")
    public void message(ChatMessageDto message) {

        // 1. 입장 메시지 처리 ("홍길동님이 입장하셨습니다.")
        if (aaa.demo.entity.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }

        // 2. 메시지 DB에 저장 (Service 호출)
        chatService.saveMessage(message);

        // 3. 구독자들에게 메시지 쏘기 (Broadcasting)
        // /sub/chat/room/1 채널을 구독 중인 사람들한테 다 뿌림
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}