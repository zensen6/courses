package com.course.courses.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@Table(name = "enroll_history")
public class Enroll_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String coursename;

    @Column
    private String courseauthor;

    @ManyToOne
    private User user;

    protected Enroll_history() {}

    public Enroll_history(String coursename, String courseauthor, User user){
        this.coursename = coursename;
        this.courseauthor = courseauthor;
    }


    public String getName(){
        return this.user.getName();
    }
    public String getEmail(){
        return this.user.getEmail();
    }

    public String getCourseName(){
        return this.coursename;
    }

    public String getCourseAuthor(){
        return this.getCourseAuthor();
    }
}
