package com.course.courses.Service;


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
    public void createHistory(Enroll_history history){
        String name = history.getName();
        String email = history.getEmail();

        String coursename = history.getCourseName();
        User user = userRepository.findByNameAndEmail(name, email);
        Course course = courseRepository.findByName(coursename);
        if(user != null && course != null){
            historyRepository.save(new Enroll_history(coursename, user));
        }else{
            throw new IllegalArgumentException("user or course does not exists!");
        }
        return;
    }

}
