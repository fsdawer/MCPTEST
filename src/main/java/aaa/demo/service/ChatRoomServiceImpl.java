package aaa.demo.service;

import aaa.demo.dto.ChatRoomDto;
import aaa.demo.entity.ChatRoom;
import aaa.demo.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    // 1. 채팅방 생성
    @Override
    @Transactional
    public ChatRoomDto createRoom(ChatRoomDto roomDto) {
        //DTO -> Entity 변환
        ChatRoom chatRoom = roomDto.toEntity();

        // DB에 저장
        chatRoomRepository.save(chatRoom);

        // 결과는 DTO로 변환해서 리턴
        return ChatRoomDto.from(chatRoom);
    }


    //2. 채팅방 전체 목록 조회
    @Override
    @Transactional(readOnly = true) // 읽기 전용 모드 (성능 최적화))
    public List<ChatRoomDto> findAllRoom() {
        // ChatRoom타입으로 DB에서 채팅방 전체 조회
        List<ChatRoom> chatRooms = chatRoomRepository.findAll();

        // 사용자한테 보여줘야 되니까 Entity -> DTO로 변환
        return chatRooms.stream()
                .map(ChatRoomDto::from)
                .collect(Collectors.toList());
    }


    // 3. 특정 채팅방 조회 (ID로 찾기)
    @Override
    @Transactional(readOnly = true)
    public ChatRoomDto findRoomById(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다"));
        return ChatRoomDto.from(chatRoom);
    }
}
