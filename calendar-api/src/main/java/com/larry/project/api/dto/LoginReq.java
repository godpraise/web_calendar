package com.larry.project.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인 요청에 대한 데이터
@Data //자동으로 Getter, Setter, equals, hashCode, toString 메서드를 생성해줌
@NoArgsConstructor(force = true)
public class LoginReq {
    private final String email;
    private final String password;
}
