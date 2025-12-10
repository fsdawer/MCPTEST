package aaa.demo.service;

import aaa.demo.dto.ChatMessageDto;
import aaa.demo.entity.ChatMessage;
import aaa.demo.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;

    // 1. 메시지 저장
    @Override
    public void saveMessage(ChatMessageDto chatMessageDto) {
        // DTO -> Entity 변환
        ChatMessage chatMessage = chatMessageDto.toEntity();
        chatMessageRepository.save(chatMessage);
    }

    // 2. 특정 채팅방의 메시지 목록 조회
    @Override
    public List<ChatMessageDto> getMessage(Long roomId) {
        // 리포지토리에서 방 번호로 찾음
        List<ChatMessage> messages = chatMessageRepository.findByRoomId(roomId);

        // 엔티티 -> DTO 변환 후 리턴
        return messages.stream()
                .map(ChatMessageDto::from)
                .collect(Collectors.toList());
    }
}
