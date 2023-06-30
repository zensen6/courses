package com.course.courses.Service;


import com.course.courses.DTO.UserRequest;
import com.course.courses.Repository.UserRepositoryInterface;
import com.course.courses.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@RequiredArgsConstructor
public class UserService implements UserServiceInterface{

    @Autowired
    private final UserRepositoryInterface userRepository;

    //@Transactional
    public void createUser(UserRequest userRequest){
        userRepository.save(new User(userRequest.getName(), userRequest.getEmail()));
        return;
    }

    @Transactional
    public User findById(Long id){
        User user = userRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);

        return user;
    }

    @Transactional
    public void deleteUser(Long id){
        User user = findById(id);
        userRepository.delete(user);
        return;
    }



}
