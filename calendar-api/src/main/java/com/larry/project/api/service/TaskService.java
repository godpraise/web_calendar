package com.larry.project.api.service;

import com.larry.project.api.dto.AuthUser;
import com.larry.project.api.dto.TaskCreateReq;
import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.repository.ScheduleRepository;
import com.larry.project.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Spring에서 서비스 역할을 하는 클래스임을 나타내는 애노테이션입니다.
@Service

// Lombok 애노테이션으로 필수 필드를 갖는 생성자를 생성합니다.
@RequiredArgsConstructor
public class TaskService {

    // UserService와 ScheduleRepository를 주입받는 생성자입니다.
    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    // 작업을 생성하는 메서드입니다.
    public void create(TaskCreateReq taskCreateReq, AuthUser authUser) {
        // TaskCreateReq 객체로부터 Schedule 엔터티를 생성합니다.
        final Schedule taskSchedule =
                Schedule.task(taskCreateReq.getTitle(),
                        taskCreateReq.getDescription(),
                        taskCreateReq.getTaskAt(),
                        userService.findByUserId(authUser.getId()));

        // ScheduleRepository를 사용하여 생성된 작업을 저장합니다.
        scheduleRepository.save(taskSchedule);
    }
}