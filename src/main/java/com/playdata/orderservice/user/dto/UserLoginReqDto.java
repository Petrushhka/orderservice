package com.playdata.orderservice.user.dto;

import lombok.*;

@Getter @ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginReqDto {
    private String email;
    private String password;
}
