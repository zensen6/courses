package com.course.courses.Repository;

import com.course.courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepositoryInterfaceV1 extends JpaRepository<Course,Long> {
    Course findByNameAndAuthor(String name, String author);
}
