package com.example.todospringsecurity.utils;

import com.example.todospringsecurity.dto.TodoDto;
import com.example.todospringsecurity.entity.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public TodoDto mapToDto(Todo todo) {

        ModelMapper mapper = new ModelMapper();
        TodoDto todoDto = mapper.map(todo, TodoDto.class);
        return todoDto;

    }

    public Todo mapToEntity(TodoDto todoDto) {
        ModelMapper mapper = new ModelMapper();
        Todo todo = mapper.map(todoDto, Todo.class);

        return todo;
    }
}
