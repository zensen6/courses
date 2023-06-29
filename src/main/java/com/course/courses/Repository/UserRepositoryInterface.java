package com.course.courses.Repository;

import com.course.courses.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User,Long> {

}
