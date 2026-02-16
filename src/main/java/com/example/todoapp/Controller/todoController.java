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

    // Load the page
    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("todoDTO", new todoRequestDTO("", ""));
        model.addAttribute("todos", tService.getAllTodosByUser("GUEST_USER"));
        return "todo-list";
    }

    // Process the form using the DTO
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

    // THIS WAS MISSING: The method to handle the Complete button!
    @GetMapping("/toggle/{id}")
    public String toggleTaskStatus(@PathVariable("id") String id) {
        tService.toggleComplete(id);
        return "redirect:/todos";
    }

    // Notice the ("id") added here as well for safety
    @GetMapping("/delete/{id}")
    public String removeTodo(@PathVariable("id") String id) {
        tService.deleteTodo(id);
        return "redirect:/todos";
    }
}