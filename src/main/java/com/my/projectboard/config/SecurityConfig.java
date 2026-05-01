package com.my.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // @WebMvcTest 슬라이스 테스트 환경에서 HttpSecurity 빈을 포함한 Security 인프라를 로드하려면 반드시 필요.
                    // 이 어노테이션이 없으면 @WebMvcTest가 이 클래스를 일반 @Configuration으로 취급하여
                    // HttpSecurity 빈을 제공하지 않아 SecurityFilterChain 생성에 실패한다. (Spring Boot 4.x 기준)

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}