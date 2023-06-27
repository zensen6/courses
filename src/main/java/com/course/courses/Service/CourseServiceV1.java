package com.course.courses.Service;


import com.course.courses.Repository.CourseRepositoryInterfaceV1;
import com.course.courses.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CourseServiceV1 implements CourseServiceInterface{

    @Autowired
    private final CourseRepositoryInterfaceV1 courseRepository;

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll().stream()
                .map(c -> new Course(c.getId(),c.getName(), c.getAuthor())).collect(Collectors.toList());
    }

    @Override
    public Course findById(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return course;
    }


    @Override
    public Course createCourse(Course course){
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long id){

        courseRepository.deleteById(id);
        return;
    }


    @Override
    public void updateCourse(Course course){
        //courseRepository.update(course);

        Course c = courseRepository.findById(course.getId())
                .orElseThrow(IllegalArgumentException::new);
        String newName = course.getName();
        String newAuthor = course.getAuthor();
        c.updateAuthor(newAuthor);
        c.updateName(newName);
        courseRepository.save(c);
    }






}
