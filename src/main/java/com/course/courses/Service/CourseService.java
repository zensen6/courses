package com.course.courses.Service;

import com.course.courses.Repository.CourseRepositoryInterface;
import com.course.courses.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CourseService implements CourseServiceInterface {

    private final CourseRepositoryInterface courseRepository;

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    @Override
    public Optional<Course> findById(int id){
        Optional<Course> course = courseRepository.findById(id);
        return course;
    }


    @Override
    public Course createCourse(Course course){
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(int id){
        Optional<Course> c = courseRepository.findById(id);
        if(c.isPresent()){
            courseRepository.deleteById(id);
        }
        return;
    }

}
