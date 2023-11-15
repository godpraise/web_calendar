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
        final User me = new User("meme", "email", "pw", LocalDate.now()); //사용자 생성
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), me); //스케쥴 생성
        assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK); //taskSchedule의 ScheduleType이 TASK인지 확인
        assertEquals(taskSchedule.toTask().getTitle(), "할일"); //taskSchedule의 Task의 Title이 "할일"인지 확인


    }
}
