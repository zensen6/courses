package com.course.courses.domain;


import javax.persistence.*;

@Entity
public class Enroll_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private User user;

    protected Enroll_history() {}

    public Enroll_history(String name, User user){
        this.name = name;
        this.user = user;
    }



}
