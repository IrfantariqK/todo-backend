package com.example.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

    private  Long id;
    private String name;

    private String title;

    private String image;

    private String age;

    private String feedback;

    private  String email;


}
