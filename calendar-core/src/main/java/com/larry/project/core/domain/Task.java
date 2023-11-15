package com.larry.project.core.domain;

import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Task {
    //Schedule이 할 일(Task)을 나타내는데 사용하는 Class
    //getTitle() 메서드를 통해 할 일의 제목을 외부에 제공
    //Task 객체를 사용하는 코드에서는 Schedule의 내용을 직접 알 필요 없이 간단하게 필요한 정보를 얻을 수 있음

    private Schedule schedule;

    public Task(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getTitle() {
        return schedule.getTitle();
    }
}
