package com.larry.project.core.domain.entity;

import com.larry.project.core.domain.Event;
import com.larry.project.core.domain.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor //Parameter가 없는 기본 생성자 생성
@Getter //Getter 메서드 자동 생성
@Table(name = "engagements") //해당 Entity가 mapping되는 DataBase Table의 이름을 지정
@Entity //해당 Class가 JPA Entity임을 나타냄
public class Engagement extends BaseEntity{

    //schedule 필드에 대한 mapping 지정
    //schedule_id Column을 참조하고, Schedule Entity와 다대일(N:1) 관계 형성
    @JoinColumn(name = "schedule_id")
    @ManyToOne
    private Schedule schedule;

    @JoinColumn(name = "attendee_id")
    @ManyToOne
    private User attendee;  //참석자
    private RequestStatus requestStatus;  //약속 수락 거절 여부

}
