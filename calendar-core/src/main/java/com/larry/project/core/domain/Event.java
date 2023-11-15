package com.larry.project.core.domain;

import com.larry.project.core.domain.entity.Engagement;
import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor //Parameter가 없는 기본 생성자 자동 생성
@Getter //Getter 메서드 자동 생성
public class Event {
    //Event Class는 이벤트와 관련된 도메인 개념 표현
    //해당 이벤트에 대한 정보는 Schedule Entity를 통해 관리

    private Schedule schedule;

    public Event(Schedule schedule) {
        this.schedule = schedule;
    }
}
