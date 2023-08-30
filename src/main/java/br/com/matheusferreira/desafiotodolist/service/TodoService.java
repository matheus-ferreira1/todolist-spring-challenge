package br.com.matheusferreira.desafiotodolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.matheusferreira.desafiotodolist.entity.Todo;
import br.com.matheusferreira.desafiotodolist.exception.BadRequestException;
import br.com.matheusferreira.desafiotodolist.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;       

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    public List<Todo> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("title").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    
    
    public List<Todo> update(Long id, Todo todo) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
        }, () -> {
            throw new BadRequestException("Todo not found");
        });        

        return list();
    }
    
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }   
}
