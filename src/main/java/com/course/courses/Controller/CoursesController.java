package com.course.courses.Controller;
import com.course.courses.Service.CourseServiceInterface;
import com.course.courses.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
//@RequestMapping(value="/api")
@RestController
@RequiredArgsConstructor
public class CoursesController {

    @Autowired //해줘야함 이유는 모르겠음..
    private CourseServiceInterface courseService;

    @GetMapping("/")
    public ResponseEntity<Course> main(Course course){
        courseService.createCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping("/showCourses")
    public List<Course> getAll() {
        return courseService.findAll();
    }

    //@GetMapping("/delete") 됨
    @DeleteMapping("/delete")
    public ResponseEntity<Object> Delete(@RequestParam Long id) throws URISyntaxException {
        System.out.println("delete");
        courseService.deleteCourse(id);
        URI redirectUri = new URI("http://localhost:3000");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> Update(Course course) throws URISyntaxException{
        System.out.println("update");
        courseService.updateCourse(course);
        URI redirectUri = new URI("http://localhost:3000");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

}
