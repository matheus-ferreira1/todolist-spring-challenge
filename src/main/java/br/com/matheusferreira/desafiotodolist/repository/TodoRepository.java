package br.com.matheusferreira.desafiotodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheusferreira.desafiotodolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
