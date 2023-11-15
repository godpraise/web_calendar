package com.larry.project.api;

import com.larry.project.core.SimpleEntity;
import com.larry.project.core.SimpleEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@EnableJpaAuditing // Entity가 생성되거나 수정될 때 감사 정보를 기록
@EntityScan("com.larry.project.core") //.core 패키지 안에서 JPA Entity를 찾도록 설정
@EnableJpaRepositories("com.larry.project.core") //JPA Repository의 위치를 지정
@RestController //RESTful 웹 서비스의 Controller임을 나타냄
@SpringBootApplication //Spring Boot 어플리케이션을 시작
public class ApiApplication {

    private final SimpleEntityRepository repository;

    public ApiApplication(SimpleEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping //HTTP GET 요청을 처리하는 핸들러 메서드 정의
    public List<SimpleEntity> findAll(){
        return repository.findAll();
    }

    @PostMapping("/save") //HTTP POST 요청을 처리하는 핸들러 메서드 정의, '/save'경로로 POST 요청이 오면 saveOne 메서드 호출
    public SimpleEntity saveOne(){
        final SimpleEntity e = new SimpleEntity();
        e.setName("hello");
        return repository.save(e);
    }
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
