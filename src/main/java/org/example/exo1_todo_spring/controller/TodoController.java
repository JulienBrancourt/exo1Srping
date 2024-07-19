package org.example.exo1_todo_spring.controller;

import org.example.exo1_todo_spring.model.Todo;
import org.example.exo1_todo_spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

//    @RequestMapping("/")
    @GetMapping("/") //plus facile à identifier que le requestMapping
    public String home() {
        return "home";
    }

    @RequestMapping("/alltodosjson")
    @ResponseBody //pour le JSON
    public List<Todo> getAll() {
        return todoService.getTodos();
    }

    @RequestMapping("/alltodos")
    public String getAllpage(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        return "listeAll";
    }

    @RequestMapping("/find")
    public String findByName(Model model) {
        Todo todo = todoService.getTodos().get(1);
        model.addAttribute("todo", todo);
        return "find";
    }

}
