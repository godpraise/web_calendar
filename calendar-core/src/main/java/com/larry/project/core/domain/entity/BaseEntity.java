package com.larry.project.core.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter //Getter 메서드 자동 생성
@MappedSuperclass //테이블을 정의하지 않고, 자식 Entity class에서 공통 mapping 정보 제공
@NoArgsConstructor //Parameter가 없는 기본 생성자 생성
@EntityListeners(AuditingEntityListener.class) //JPA에서 제공하는 Entity 감시(ex: 생성일, 수정일 자동 설정)를 활성화
public abstract class BaseEntity {
    //다른 Entity Class들이 상속받아 공통 필드와 생성/수정 시간을 사용할 수 있도록 하는 Class

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity Column을 사용하여 자동으로 생성되는 키
    private Long id;

    @CreatedDate //Entity가 생성될 때 현재 날짜와 시간이 자동 설정
    private LocalDateTime createdAt;

    @LastModifiedDate //Entity가 수정될 때 현재 날짜와 시간이 자동 설정
    private LocalDateTime updatedAt;

    public BaseEntity(Long id) {
        this.id = id;
    }
}
