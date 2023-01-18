package com.in28minutes.controllers;

import com.in28minutes.models.Todo;
import com.in28minutes.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoRestController {
    @Autowired
    TodoService service;


    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Todo> retrieveAllTodos(){
        return service.retrieveTodos("test");

    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public Todo retrieveTodoById(@PathVariable int id){
        return service.retrieveTodo(id);

    }

}
