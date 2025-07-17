package com.alura.foroHub.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private Long id;
    private String Title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status = true;
    private String author ;
    private Course course;
    private List<Answers> answers;
    private UserModel userModel;


}
