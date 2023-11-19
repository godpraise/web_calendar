package com.larry.project.api.dto;

// AuthUser 클래스는 사용자 인증 정보를 나타냅니다.

import lombok.Getter;

@Getter
public class AuthUser {
    // 사용자의 고유 식별자를 저장하는 필드입니다.
    private final Long id;

    // private 생성자로 외부에서 직접 객체를 생성하는 것을 막고, of 메서드를 통해 생성합니다.
    private AuthUser(Long id){
        this.id = id;
    }

    // 주어진 사용자 ID로 AuthUser 객체를 생성하여 반환하는 정적 팩토리 메서드입니다.
    public static AuthUser of(Long id){
        return new AuthUser(id);
    }
}
