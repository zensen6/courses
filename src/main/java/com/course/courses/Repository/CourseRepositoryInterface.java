package com.course.courses.Repository;

import com.course.courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;


public interface CourseRepositoryInterface {
    void save(Course course);
    List<Course> findAll();
    Optional<Course> findById(int id);
    void deleteById(int id);

    void update(Course course);

}
