package com.larry.project.core.service;

import com.larry.project.core.domain.entity.User;
import com.larry.project.core.domain.entity.repository.UserRepository;
import com.larry.project.core.dto.UserCreateReq;
import com.larry.project.core.util.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service //spring한테 이 Class가 Service 역할을 한다는걸 알려줌
@RequiredArgsConstructor //Class의 final 필드를 가지고 생성자를 자동 생성
public class UserService {

    private final Encryptor encryptor; //비밀번호 암호화
    private final UserRepository userRepository; //사용자 DB 조작

    @Transactional
    public User create(UserCreateReq userCreateReq) {
        //사용자의 생성과 조회 기능 제공

        //주어진 이메일이 이미 존재하는지 확인하고, 존재하면 예외 발생시킴
        userRepository.findByEmail(userCreateReq.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("user already existed!");
                });
        return userRepository.save(new User(
                userCreateReq.getName(),
                userCreateReq.getEmail(),
                encryptor.encrypt(userCreateReq.getPassword()), //비밀번호는 Encryptor를 사용하여 암호화
                userCreateReq.getBirthday()
        ));
    }

    @Transactional
    public Optional<User> findPwMatchUser(String email, String password) {
        //주어진 이메일로 사용자를 찾고, 사용자가 존재하면 주어진 비밀번호와 일치하는지 확인
        return userRepository.findByEmail(email)
                .map(user -> user.isMatch(encryptor, password) ? user : null);
    }

    @Transactional
    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("no user by id."));
    }
}
