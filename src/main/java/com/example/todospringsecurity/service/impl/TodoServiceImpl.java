package com.example.todospringsecurity.service.impl;

import com.example.todospringsecurity.dto.TodoDto;
import com.example.todospringsecurity.entity.Todo;
import com.example.todospringsecurity.repository.TodoRepository;
import com.example.todospringsecurity.service.TodoService;
import com.example.todospringsecurity.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository _todorepository;
    @Autowired
    private Mapper mapper;
    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = mapper.mapToEntity(todoDto);
        Todo newTodo = _todorepository.save(todo);
        TodoDto todoResponse = mapper.mapToDto(newTodo);
        return todoResponse;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = (List<Todo>) _todorepository.findAll();
        List<TodoDto> todoDtoList = todos.stream().map(todo -> mapper.mapToDto(todo)).collect(Collectors.toList());
        return todoDtoList;
    }

    @Override
    public TodoDto getTodosById(Integer id) {
        Todo todo = _todorepository.findById(id).orElse(null);
        return mapper.mapToDto(todo);
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Integer id) {
        Todo todo = _todorepository.findById(id).orElse(null);
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        Todo updateTodo = _todorepository.save(todo);
        return mapper.mapToDto(updateTodo);
    }

    @Override
    public void deleteTodoById(Integer id) {
        Todo todo = _todorepository.findById(id).orElse(null);
        _todorepository.deleteById(id);
    }
}
