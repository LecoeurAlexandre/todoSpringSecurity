package com.example.todospringsecurity.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

    private Integer id;
    private String title;
    private String description;
    private boolean completed;
}