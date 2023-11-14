package com.larry.project.core.domain.entity;

import com.larry.project.core.domain.Event;
import com.larry.project.core.domain.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table(name = "engagements")
@Entity
public class Engagement extends BaseEntity{

    @JoinColumn(name = "schedule_id")
    @ManyToOne
    private Schedule schedule;

    @JoinColumn(name = "attendee_id")
    @ManyToOne
    private User attendee;  //참석자
    private RequestStatus requestStatus;  //약속 수락 거절 여부

}
