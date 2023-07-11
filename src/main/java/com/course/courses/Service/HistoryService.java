package com.course.courses.Service;


import com.course.courses.DTO.HistoryRequest;
import com.course.courses.Repository.CourseRepository;
import com.course.courses.Repository.CourseRepositoryInterfaceV1;
import com.course.courses.Repository.HistoryRepository;
import com.course.courses.Repository.UserRepositoryInterface;
import com.course.courses.domain.Course;
import com.course.courses.domain.Enroll_history;
import com.course.courses.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HistoryService implements HistoryServiceInterface{


    @Autowired
    private final HistoryRepository historyRepository;
    @Autowired
    private final UserRepositoryInterface userRepository;

    @Autowired
    private final CourseRepositoryInterfaceV1 courseRepository;


    @Transactional
    public void createHistory(HistoryRequest history){
        String name = history.getUsername();
        String email = history.getEmail();
        String coursename = history.getCoursename();

        System.out.println(coursename + " service level email");

        User user = userRepository.findByNameAndEmail(name, email);
        Course course = courseRepository.findByName(coursename);
        if(user != null && course != null){

            System.out.println(course.getName() + " servie level username");

            historyRepository.save(new Enroll_history(coursename, user));
        }else{
            throw new IllegalArgumentException("user or course does not exists!");
        }
        return;
    }

}
