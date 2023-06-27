package com.course.courses.Service;

import com.course.courses.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {
    Course findById(Long id);
    List<Course> findAll();
    Course createCourse(Course course);
    void deleteCourse(Long id);

    void updateCourse(Course course);

}
