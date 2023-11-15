package com.larry.project.core.dto;

import lombok.Data;

import java.time.LocalDate;

@Data //Getter, Setter, toString, equals, hashCode 메서드 등을 자동으로 생성함으로써, 코드의 간결성과 가독성을 높임
public class UserCreateReq {
    //사용자 생성과 관련된 정보를 간결하게 표현
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthday;
}
