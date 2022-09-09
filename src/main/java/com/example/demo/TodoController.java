package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {

        List<Todo> list = new ArrayList<>();

        for (int i = 0; i<=1200; i++){
            list.add(new Todo("description:" + i, "details:" + i, true));
        }
        todoRepository.saveAll(list);
        return todo;
    }

    @RequestMapping("/get")
    public Iterable<Todo> getTodos() {
        return todoRepository.findAll();
    }
}
