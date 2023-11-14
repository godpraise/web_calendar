package com.larry.project.core;

import com.larry.project.core.domain.ScheduleType;
import com.larry.project.core.domain.entity.Engagement;
import com.larry.project.core.domain.Event;
import com.larry.project.core.domain.RequestStatus;
import com.larry.project.core.domain.entity.Schedule;
import com.larry.project.core.domain.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User me = new User("meme", "email", "pw", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), me);
        assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK);
        assertEquals(taskSchedule.toTask().getTitle(), "할일");


    }
}
