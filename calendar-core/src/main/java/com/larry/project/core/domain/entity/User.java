package com.larry.project.core.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor // 기본 생성자 자동 생성
@Getter //getter method 자동 생성
@Table(name = "users")
@Entity
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
}
