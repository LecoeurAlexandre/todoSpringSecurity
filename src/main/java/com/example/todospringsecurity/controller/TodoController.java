package com.example.todospringsecurity.controller;

import com.example.todospringsecurity.dto.TodoDto;
import com.example.todospringsecurity.entity.Todo;
import com.example.todospringsecurity.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService _todoService;

    @GetMapping("")
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        return new ResponseEntity(_todoService.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(_todoService.createTodo (todoDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable(name = "id") Integer id){
        TodoDto todoResponse = _todoService.updateTodo(todoDto, id);
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable(name = "id") Integer id){

        _todoService.deleteTodoById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(_todoService.getTodosById(id));
    }
}
