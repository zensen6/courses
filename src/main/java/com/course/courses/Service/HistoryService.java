package com.course.courses.Service;


import com.course.courses.Repository.HistoryRepository;
import com.course.courses.Repository.UserRepositoryInterface;
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


    @Transactional
    public void createHistory(Enroll_history history){
        String name = history.getName();
        String email = history.getEmail();
        User user = userRepository.findByNameAndEmail(name, email);


        historyRepository.save(history);
        return;
    }

}
