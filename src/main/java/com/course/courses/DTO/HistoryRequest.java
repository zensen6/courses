package com.course.courses.DTO;


import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class HistoryRequest {
    private String username;
    private String email;
    private String coursename;
    private String courseauthor;

}
