package aaa.demo.controller;

import aaa.demo.dto.ChatRoomDto;
import aaa.demo.service.ChatRoomService;
import aaa.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class RoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 생성
    @PostMapping("/room")
    public ChatRoomDto create(@RequestBody ChatRoomDto chatRoomDto) {
        // @RequestBody: 프론트에서 보낸 JSON을 DTO로 받아줌
        return chatRoomService.createRoom(chatRoomDto);
    }

    //2. 채팅방 전체 목록 조회
    @GetMapping("/rooms")
    public List<ChatRoomDto> findAllRoom() {
        return chatRoomService.findAllRoom();
    }

    // 3. 채팅방 하나 조회
    // GET /chat/room/1
    @GetMapping("/room/{roomId}")
    public ChatRoomDto roomInfo(@PathVariable Long roomId) {
        return chatRoomService.findRoomById(roomId);
    }

}
