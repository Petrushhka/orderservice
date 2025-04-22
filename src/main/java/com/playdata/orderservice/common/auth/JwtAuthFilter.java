package com.playdata.orderservice.common.auth;

//클라이언트가 전송한 토큰을 검사하는 필터
// 스프링 시큐리티에 등록해서 사용할 겁니다.

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 우리가 만드는 이 필터가 요청 한번 당 자동으로 동작할 수 있게끔
        // OncePerRequestFilter를 상속 받음.
        // 메서드 내에 필터가 해야 할 일을 작성하면 됩니다.

        // 요청과 함께 전달된 JWT를 얻어와야 합니다.
        // JWT는 클라이언트 단에서 요청 헤더에 담겨져서 전달됩니다.


    }
}
