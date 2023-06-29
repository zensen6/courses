package com.course.courses.domain;


import javax.persistence.*;

@Entity
public class EnrollHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private User user;

    protected EnrollHistory() {}





}
