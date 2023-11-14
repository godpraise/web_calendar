package com.larry.project.core.domain.entity;

import com.larry.project.core.domain.Event;
import com.larry.project.core.domain.Notification;
import com.larry.project.core.domain.ScheduleType;
import com.larry.project.core.domain.Task;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "schedules")
@Entity
public class Schedule extends BaseEntity{

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String title;
    private String description;

    @JoinColumn(name = "writer_id")
    @ManyToOne
    private User writer;

    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;

    public static Schedule task(String title, String description, LocalDateTime startAt, LocalDateTime endAt, User writer){
        return Schedule.builder()
                .title(title)
                .description(description)
                .startAt(startAt)
                .endAt(endAt)
                .writer(writer)
                .scheduleType(ScheduleType.EVENT)
                .build();
    }
    public static Schedule notification(String title, LocalDateTime notifyAt, User writer){
        return Schedule.builder()
                .title(title)
                .startAt(notifyAt)
                .writer(writer)
                .scheduleType(ScheduleType.NOTIFICATION)
                .build();
    }
    public Task toTask(){
        return new Task(this);
    }

    public Event toEvent(){
        return new Event(this);
    }

    public Notification toNotification(){
        return new Notification(this);
    }
}
