package com.course.courses.Repository;

import com.course.courses.domain.Enroll_history;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<Enroll_history, Long> {
}
