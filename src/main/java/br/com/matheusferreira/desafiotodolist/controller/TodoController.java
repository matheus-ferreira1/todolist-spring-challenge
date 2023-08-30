package br.com.matheusferreira.desafiotodolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusferreira.desafiotodolist.entity.Todo;
import br.com.matheusferreira.desafiotodolist.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;
    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo) {
        return todoService.create(todo);
    }
    
    @GetMapping
    List<Todo> list(Todo todo) {
        return todoService.list();
    }
    
    @PutMapping("{id}")
    List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }
    
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
 