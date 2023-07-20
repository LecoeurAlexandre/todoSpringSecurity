package com.example.todospringsecurity.service;

import com.example.todospringsecurity.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);
    List<TodoDto> getAllTodos();
    TodoDto getTodosById(Integer id);
    TodoDto updateTodo(TodoDto todoDto, Integer id);
    void deleteTodoById(Integer id);

}
