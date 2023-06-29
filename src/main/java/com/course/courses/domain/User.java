package com.course.courses.domain;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id = null;


        @Column
        private String name;

        @Column
        private String email;

        protected User(){}

        public User(String name, String email){
                if(name == null || name.isBlank() || email == null || email.isBlank()){
                        throw new IllegalArgumentException("name or email should not be blank or null");
                }
                this.name = name;
                this.email = email;
        }

        @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
        private List<Enroll_history> userEnrollHistory = new ArrayList<>();


        public void updateName(String name){
                this.name = name;
                return;
        }

        public Long getId(){
                return this.id;
        }


}
