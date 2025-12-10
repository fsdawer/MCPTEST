-- 1. 채팅방 테이블
CREATE TABLE chat_room (
                           room_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '채팅방 ID',
                           room_name VARCHAR(100) NOT NULL COMMENT '채팅방 이름',
                           created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '방 생성 시간'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 2. 채팅 메시지 테이블
CREATE TABLE chat_message (
                              message_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '메시지 ID',
                              room_id BIGINT NOT NULL COMMENT '어느 방 메시지인지(FK)',
                              type VARCHAR(20) DEFAULT 'TALK' COMMENT '메시지 타입 (ENTER, TALK)',
                              sender VARCHAR(50) NOT NULL COMMENT '보낸 사람 닉네임',
                              message TEXT COMMENT '메시지 내용',
                              created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '전송 시간',

    -- 검색 속도를 위해 room_id에 인덱스 걸기 (필수)
                              INDEX idx_room_id (room_id),
    -- 외래키 설정 (옵션: 방 삭제되면 메시지도 다 지울지 결정)
                              CONSTRAINT fk_chat_room FOREIGN KEY (room_id) REFERENCES chat_room (room_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;