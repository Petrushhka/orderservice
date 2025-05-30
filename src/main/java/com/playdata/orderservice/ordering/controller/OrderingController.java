package com.playdata.orderservice.ordering.controller;

import com.playdata.orderservice.common.auth.TokenUserInfo;
import com.playdata.orderservice.common.dto.CommonResDto;
import com.playdata.orderservice.ordering.dto.OrderingSaveReqDto;
import com.playdata.orderservice.ordering.entity.Ordering;
import com.playdata.orderservice.ordering.repository.OrderingRepository;
import com.playdata.orderservice.ordering.service.OrderingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderingController {

    private final OrderingService orderingService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(
            // 전역 인증 정보를 담아놓는 ContextHolder에서 메서드 호출시에
            // 사용자 인증 정보를 전달해주는 어노테이션
            @AuthenticationPrincipal TokenUserInfo userInfo,
            @RequestBody List<OrderingSaveReqDto> dtoList
            ) {
        log.info("/order/create: POST, userInfo: {}", userInfo);
        log.info("dtoListL: {}", dtoList);

        Ordering ordering = orderingService.createOrder(dtoList, userInfo);

        CommonResDto resDto =
                new CommonResDto(HttpStatus.CREATED, "정상 주문 완료", ordering.getId());
                return new ResponseEntity<>(resDto,HttpStatus.CREATED);
    }

}
