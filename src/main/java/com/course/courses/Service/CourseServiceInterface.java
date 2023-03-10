package com.course.courses.Service;

import com.course.courses.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {
    Optional<Course> findById(int id);
    List<Course> findAll();
    Course createCourse(Course course);
    void deleteCourse(int id);

    void updateCourse(Course course);

}
