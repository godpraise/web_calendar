package com.larry.project.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
    //JpaRepository는 기본적인 CRUD 연산 제공
}
