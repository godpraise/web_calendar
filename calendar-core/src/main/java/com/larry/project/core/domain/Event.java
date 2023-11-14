package com.larry.project.core.domain;

import com.larry.project.core.domain.entity.Engagement;
import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
public class Event {

    private Schedule schedule;

    public Event(Schedule schedule) {
        this.schedule = schedule;
    }
}
