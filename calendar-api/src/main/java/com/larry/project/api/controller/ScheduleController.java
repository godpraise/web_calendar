package com.larry.project.api.controller;

import com.larry.project.api.dto.AuthUser;
import com.larry.project.api.dto.TaskCreateReq;
import com.larry.project.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

// LoginService에서 가져온 LOGIN_SESSION_KEY를 정적으로 임포트합니다.
import static com.larry.project.api.service.LoginService.LOGIN_SESSION_KEY;

// 이 컨트롤러의 기본 경로를 지정하는 RequestMapping입니다.
@RequestMapping("/api/schedules")

// Lombok 애노테이션으로 필수 필드를 갖는 생성자를 생성합니다.
@RequiredArgsConstructor

// 이 클래스가 Spring REST 컨트롤러임을 나타내는 애노테이션입니다.
@RestController
public class ScheduleController {

    // TaskService를 나타내는 final 필드로, 이는 생성자를 통해 주입됩니다.
    private final TaskService taskService;

    // 작업을 생성하기 위한 HTTP POST 매핑입니다.
    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(
            @RequestBody TaskCreateReq taskCreateReq,
            HttpSession session){
        // 세션에서 사용자 ID를 가져옵니다.
        final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);

        // 사용자 ID가 없으면 예외를 발생시킵니다.
        if (userId == null){
            throw new RuntimeException("잘못된 요청. 세션이 없습니다.");
        }

        // TaskService를 사용하여 작업을 생성합니다.
        taskService.create(taskCreateReq, AuthUser.of(userId));

        // HTTP 응답으로 성공을 알립니다.
        return ResponseEntity.ok().build();
    }
}
