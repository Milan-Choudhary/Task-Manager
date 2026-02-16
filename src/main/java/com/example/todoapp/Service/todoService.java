package com.example.todoapp.Service;

import com.example.todoapp.Model.todoModel;
import com.example.todoapp.Repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class todoService {

    @Autowired
    private todoRepository todoRepo;

    // 1. Create a new task
    public todoModel createTodo(todoModel todo) {
        return todoRepo.save(todo);
    }

    // 2. Get all tasks for a specific user
    public List<todoModel> getAllTodosByUser(String userId) {
        return todoRepo.findByUserId(userId);
    }

    // 3. Get a single task by ID
    public Optional<todoModel> getTodoById(String id) {
        return todoRepo.findById(id);
    }

    // 4. Update a task (e.g., changing the title or description)
    public todoModel updateTodo(String id, todoModel updatedTodo) {
        return todoRepo.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepo.save(todo);
        }).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // 5. Toggle completion status
    public todoModel toggleComplete(String id) {
        todoModel todo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        todo.setCompleted(!todo.isCompleted());
        return todoRepo.save(todo);
    }

    // 6. Delete a task
    public void deleteTodo(String id) {
        todoRepo.deleteById(id);
    }
}