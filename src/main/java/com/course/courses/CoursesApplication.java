package com.course.courses;

import com.course.courses.Repository.CourseRepositoryInterface;
import com.course.courses.domain.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class CoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

	/*
	@Bean
	CommandLineRunner loadData(CourseRepositoryInterface courseRepository){
		return (args) -> {
			Course c1 = new Course();
			Course c2 = new Course();
			c1.setName("c");
			c2.setName("c");
			c1.setAuthor("aa");
			c2.setAuthor("bb");
			//courseRepository.save(c1);
			//courseRepository.save(c2);
			System.out.println("done this");
		};

	}
	*/




}
