package com.larry.project.core.domain.entity.repository;

import com.larry.project.core.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
