package com.larry.project.core.domain;

import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor //Parameter가 없는 기본 생성자 자동 생성
@Getter //Getter 메서드 자동 생성
public class Notification {

    private Schedule schedule;

    public Notification(Schedule schedule) {
        this.schedule = schedule;
    }
}
