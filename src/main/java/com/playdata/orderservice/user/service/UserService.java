package com.playdata.orderservice.user.service;

import com.playdata.orderservice.user.dto.UserSaveReqDto;
import com.playdata.orderservice.user.entity.User;
import com.playdata.orderservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // @Component 해도 되는데 서비스 게층이니깐..
@RequiredArgsConstructor
public class UserService {
    // UserService는 UserRepository에 의존하고 잇다. -> Repository 기능을 써야한다.
    // repository 객체를 자동으로 주입받자.(JPA가 만들어서 컨테이너에 등록해 놓음)
    private final UserRepository userRepository;

    //컨트롤러가 이 메서드를 호출할 것이다.
    // 그리고 지가 전달받은 dto를 그대로 넘길 것이다.
public User userCreate(UserSaveReqDto dto){
    Optional<User> foundEmail = userRepository.findByEmail(dto.getEmail());

    if(foundEmail.isPresent()){
        // 이메일이 존재? -> 이메일 중복 -> 회원가입 불가!
        // 예외를 일부러 생성시켜서 컨트롤러가 감지하게 할겁니다.
        throw new IllegalArgumentException("이미 존재하는 이메일 입니다!");
    }

    // 이메일 중복 안됨 -> 회원가입 진행하자.
    // dto를 entity로 변환하는 로직이 필요!!
    User user = dto.toEntity();
    User saved = userRepository.save(user);
    return saved;

}

}
