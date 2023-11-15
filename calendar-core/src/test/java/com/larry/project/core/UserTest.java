package com.larry.project.core;

import com.larry.project.core.domain.entity.User;
import com.larry.project.core.util.Encryptor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private final Encryptor alwaysMatchEncryptor = new Encryptor() {
        //테스트에 사용될 항상 일치하는 Encryptor 인터페이스 구현

        @Override
        public String encrypt(String origin) {
            return origin;
        }

        @Override
        public boolean isMatch(String origin, String hashed) {
            return true;
        }
    };

    @Test
    void isMatchTest(){
        final User me = new User("meme", "email", "pw", LocalDate.now()); //사용자 생성
        assertEquals(true, me.isMatch(alwaysMatchEncryptor, "aaaaa"));
        //사용자 객체의 isMatch 메서드가 항상 true를 반환하는지 확인
    }
}
