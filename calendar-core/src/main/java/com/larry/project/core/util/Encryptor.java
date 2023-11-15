package com.larry.project.core.util;

public interface Encryptor {
    String encrypt(String origin); //원본 비밀번호를 암호화된 문자열로 반환
    boolean isMatch(String origin, String hashed); // 원본 비밀번호와 암호화된 비밀번호를 받아서 일치하는지 확인
}
