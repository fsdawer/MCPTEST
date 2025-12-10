package aaa.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 1. 코드는 ws://localhost:8080/ws-stomp 로 연결됩니다.
        registry.addEndpoint("/ws-stomp")
                .setAllowedOriginPatterns("*") // 모든 도메인에서 접속 허용
                .withSockJS(); // SockJS 지원
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 2. 메시지 구독 요청 url (Subscribe) -> 프론트에서 메시지 받을 때
        registry.enableSimpleBroker("/sub");

        // 3. 메시지 발행 요청 url (Publish) -> 프론트에서 메시지 보낼 때
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
