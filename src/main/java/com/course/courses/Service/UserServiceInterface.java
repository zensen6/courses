package com.course.courses.Service;

import com.course.courses.DTO.UserRequest;
import com.course.courses.domain.User;

public interface UserServiceInterface {

    User findById(Long id);

    User findByNameAndEmail(UserRequest userRequest);

    void createUser(UserRequest userRequest);
    void deleteUser(Long id);

}
