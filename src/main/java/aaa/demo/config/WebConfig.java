package aaa.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 1. 모든 주소에 대해서
                .allowedOriginPatterns("*") // 2. 모든 도메인(IP)의 요청을 허용한다
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // 3. 이 방식들을 허용한다
                .allowCredentials(true); // 4. 쿠키/인증 정보 포함 허용
    }
}
