package com.larry.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//회원 가입 시 필요한 정보
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SignUpReq {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthday; //LocalDate는 Java 8에서 제공되는 날짜를 다루기 위한 클래스
}
