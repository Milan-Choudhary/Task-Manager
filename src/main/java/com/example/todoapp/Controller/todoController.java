package com.example.todoapp.Controller;

import com.example.todoapp.DTO.todoRequestDTO;
import com.example.todoapp.Model.todoModel;
import com.example.todoapp.Service.todoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class todoController {

    @Autowired
    private todoService tService;

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("todoDTO", new todoRequestDTO("", ""));
        model.addAttribute("todos", tService.getAllTodosByUser("GUEST_USER"));
        return "todo-list";
    }


    @PostMapping("/save")
    public String saveTodo(@Valid @ModelAttribute("todoDTO") todoRequestDTO dto,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            model.addAttribute("todos", tService.getAllTodosByUser("GUEST_USER"));
            return "todo-list";
        }

        todoModel newTodo = new todoModel();
        newTodo.setTitle(dto.title());
        newTodo.setDescription(dto.description());
        newTodo.setUserId("GUEST_USER");

        tService.createTodo(newTodo);
        return "redirect:/todos";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTaskStatus(@PathVariable("id") String id) {
        tService.toggleComplete(id);
        return "redirect:/todos";
    }


    @GetMapping("/delete/{id}")
    public String removeTodo(@PathVariable("id") String id) {
        tService.deleteTodo(id);
        return "redirect:/todos";
    }
}