package com.larry.project.core.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component //해당 Class의 인스턴스를 주입받아 사용할 수 있도록 스프링에게 알려줌
public class BCryptEncryptor implements Encryptor {
    @Override
    public String encrypt(String origin) {
        return BCrypt.hashpw(origin, BCrypt.gensalt());
    }
    //origin이라는 원본 비밀번호를 BCrypt 해시 함수를 사용하여 안전하게 암호화
    //gensalt() 메서드는 새로운 salt를 생성
    //salt는 같은 비밀번호라도 매번 다른 해시값을 생성하여 보안성 향상

    @Override
    public boolean isMatch(String origin, String hashed) {
        try {
            return BCrypt.checkpw(origin, hashed);
            //origin(원본 비밀번호)과 hased(암호화된 비밀번호)가 일치하는지 확인
            //일치하면 true, 아니면 false

        }catch (Exception e){
            return false;
            //checkpw 메서드는 예외를 던지지 않기 때문에 try-catch를 사용하여 예외가 발생한 경우에도 false를 반환하도록 처리
        }
    }
}
