package aaa.demo.service;

import aaa.demo.dto.ChatRoomDto;

import java.util.List;

public interface ChatRoomService {

    // 1. 채팅방 생성
    ChatRoomDto createRoom(ChatRoomDto roomDto);

    //2. 채팅방 전체 목록 조회
    List<ChatRoomDto> findAllRoom();

    // 3. 특정 채팅방 조회 (ID로 찾기)
    ChatRoomDto findRoomById(Long roomId);




}
