package com.playdata.orderservice.common.auth;

import com.playdata.orderservice.user.entity.Role;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TokenUserInfo {

    private String  email;
    private Role role;


}
