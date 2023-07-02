package com.course.courses.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HistoryRequest {
    private String username;
    private String email;
    private String coursename;
    private String courseauthor;

}
