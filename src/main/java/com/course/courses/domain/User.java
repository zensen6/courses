package com.course.courses.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        protected User(){}

        @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
        private List<EnrollHistory> userEnrollHistory = new ArrayList<>();


        public void updateName(String name){
                this.name = name;
                return;
        }



}
