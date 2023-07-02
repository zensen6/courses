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

    private String name;
    @ManyToOne
    private User user;

    protected Enroll_history() {}

    public Enroll_history(String name, User user){
        this.name = name;
        this.user = user;
    }

    public String getEmail(){
        return this.user.getEmail();
    }

}
