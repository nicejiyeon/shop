package com.apple.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Configuration, EnableWebSecurity 어노테이션을 사용하면
// Spring Security 설정파일로 사용
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Spring Secuirty를 적용하면 모든 페이지 로그인 체크 필수
    // 예외 페이지가 있을 수 있으니, 어떤 페이지를 체크할 건지 설정 가능
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );
        return http.build();
    }

}
