package org.example.exo1_todo_spring.service;

import lombok.Getter;
import lombok.Setter;
import org.example.exo1_todo_spring.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter //permet d'avoir des getter pour toutes les propriétés
@Setter
public class TodoService {
    private List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<Todo>();
        todos.add(new Todo("créer model", "création du modèle", true));
        todos.add(new Todo("créer service", "création du service", false));
        todos.add(new Todo("créer controller", "création du controller", true));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
