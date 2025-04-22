package com.playdata.orderservice.common.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity // 권한 검사를 컨트롤러의 메서드에서 전역적으로 수행하기 위한 설정.
public class SecurityConfig {

    // security 기본 설정 ( 권한 처리, 초기 로그인 화면 없애기 등등...)
    @Bean // 이 메서드가 리턴하는 시큐리티 설정을 빈으로 등록하겠다.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 스프링 시큐리티에서 기본으로 제공하는 CSRF 토큰 공격을 방지하기 위한 장치 해제.
        // CSRF(Cross Site Request Forgery) 사이트 간 요청 위조
        http.csrf(csrf -> csrf.disable());

        //세션 관리 상태를 사용하지 않고
        // STATELESS한 토큰을 사용하겠다.
        http.sessionManagement(session
                -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 요청 권한 설정(어떤 url이냐에 따라 검사를 할 지 말지를 결정)
        http.authorizeHttpRequests((auth -> {
            auth.requestMatchers("/user/create", "/user/doLogin").permitAll()
                    .anyRequest().authenticated();
        }));
        // "/user/creat", "/user/doLogin" 은 인증 검사가 필요 없다고 설정했고
        // 나머지 요청들은 권한 검사가 필요하다고 세팅 했습니다.
        // 권한 검사가 필요한 요청들을 어던 필터로 검사할지를 추가해 주면 됩니다.

    }

}
