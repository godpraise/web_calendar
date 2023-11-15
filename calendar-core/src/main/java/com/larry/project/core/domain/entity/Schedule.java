package com.larry.project.core.domain.entity;

import com.larry.project.core.domain.Event;
import com.larry.project.core.domain.Notification;
import com.larry.project.core.domain.ScheduleType;
import com.larry.project.core.domain.Task;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE) //Builder Pattern을 자동으로 생성, 생성자의 접근 제어 수준을 private으로 설정
@AllArgsConstructor //모든 생성자 자동 생성
@NoArgsConstructor //Parameter가 없는 기본 생성자 자동 생성
@Getter //Class에 대한 Getter 메서드 자동 생성
@Table(name = "schedules") //schedules라는 이름의 Table과 Mapping
@Entity //해당 Class가 JPA Entity임을 나타냄
public class Schedule extends BaseEntity{

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String title;
    private String description;

    //writer 필드에 대한 매핑 지정
    //writer_id Column을 참조하고, User Entity와 다대일(N:1) 관계를 형성
    @JoinColumn(name = "writer_id")
    @ManyToOne
    private User writer;

    @Enumerated(EnumType.STRING) // scheduleType 이라는 열거형 타입을 문자열로 저장
    private ScheduleType scheduleType;

    //이벤트 스케쥴을 생성하는 정적 메서드
    public static Schedule event(String title, String description, LocalDateTime startAt, LocalDateTime endAt, User writer){
        return Schedule.builder()
                .title(title)
                .description(description)
                .startAt(startAt)
                .endAt(endAt)
                .writer(writer)
                .scheduleType(ScheduleType.EVENT)
                .build();
    }
    public static Schedule task(String title, String description, LocalDateTime taskAt, User writer){
        return Schedule.builder()
                .title(title)
                .startAt(taskAt)
                .writer(writer)
                .scheduleType(ScheduleType.TASK)
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
