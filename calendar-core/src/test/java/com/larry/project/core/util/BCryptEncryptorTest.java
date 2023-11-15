package com.larry.project.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BCryptEncryptorTest {
    //비밀번호를 안전하게 암호화하고, 암호화된 비미런호와 일치 여부 Test

    @Test //테스트 메서드
    void test(){
        final String origin = "password"; //원본 비밀번호 정의
        final Encryptor encryptor = new BCryptEncryptor();
        final String hash = encryptor.encrypt(origin); //원본 비밀번호를 암호화하여 해시값 생성

        assertTrue(encryptor.isMatch(origin, hash));
        //원본 비밀번호와 해시값을 비교하여 true 반환하는지 확인
        //즉 원본 비밀번호와 암호화된 해시값이 일치하는지 확인

        final String origin2 = "passwordd";
        assertFalse(encryptor.isMatch(origin2, hash));
    }
}
