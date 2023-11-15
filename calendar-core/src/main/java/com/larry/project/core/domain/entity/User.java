package com.larry.project.core.domain.entity;

import com.larry.project.core.util.Encryptor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor // Parameter 업슨 기본 생성자 자동 생성
@Getter //getter method 자동 생성
@Table(name = "users") //users라는 이름의 Table과 Mapping
@Entity //해당 Class가 JPA Entity임을 나타냄
public class User extends BaseEntity{

    private String name;
    private String email;
    private String password;
    private LocalDate birthday;

    public User(String name, String email, String password, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    //비밀번호 일치 여부 확인
    public boolean isMatch(Encryptor encryptor, String password) {
        return encryptor.isMatch(password, this.password);
    }
}
