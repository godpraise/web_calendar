package com.larry.project.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

// Lombok의 @Data 애노테이션을 통해 자동으로 게터, 세터, toString 등을 생성합니다.
@Data
public class TaskCreateReq {
    // 작업의 제목을 나타내는 필드입니다.
    private final String title;

    // 작업에 대한 설명을 나타내는 필드입니다.
    private final String description;

    // 작업이 예정된 일시를 나타내는 필드입니다.
    private final LocalDateTime taskAt;
}