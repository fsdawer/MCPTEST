package aaa.demo.service;

import aaa.demo.dto.ChatMessageDto;

import java.util.List;

public interface ChatService {

    // 1. 메시지 저장
    void saveMessage(ChatMessageDto chatMessageDto);


    // 2. 특정 채팅방의 메시지 목록 조회
    List<ChatMessageDto> getMessage(Long roomId);
}
