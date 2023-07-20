package com.example.todospringsecurity.repository;

import com.example.todospringsecurity.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository <Todo, Integer>{

}
