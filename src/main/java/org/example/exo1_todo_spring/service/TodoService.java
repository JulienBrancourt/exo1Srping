package org.example.exo1_todo_spring.service;

import org.example.exo1_todo_spring.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    public List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<Todo>();
        todos.add(new Todo("créer model", "création du modèle", true));
        todos.add(new Todo("créer service", "création du service", false));
        todos.add(new Todo("créer controller", "création du controller", true));
    }
}
