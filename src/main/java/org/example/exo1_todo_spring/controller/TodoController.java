package org.example.exo1_todo_spring.controller;

import org.example.exo1_todo_spring.model.Todo;
import org.example.exo1_todo_spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Todo> getAll(TodoService todoService) {
        return todoService.todos;
    }

    @RequestMapping("/allpage")
    public String getAllpage(Model model) {
        model.addAttribute("todos", todoService.todos);
        return "listeAll";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String findByName(Model model, String name) {
        Optional<Todo> montodo = todoService.todos.stream().filter(t -> t.getName().equals(name)).findFirst();
        montodo.ifPresent(t -> model.addAttribute("todo", t));
        return "find";
    }

}
