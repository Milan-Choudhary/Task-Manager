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


    public todoModel createTodo(todoModel todo) {
        return todoRepo.save(todo);
    }


    public List<todoModel> getAllTodosByUser(String userId) {
        return todoRepo.findByUserId(userId);
    }

    public Optional<todoModel> getTodoById(String id) {
        return todoRepo.findById(id);
    }

    public todoModel updateTodo(String id, todoModel updatedTodo) {
        return todoRepo.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepo.save(todo);
        }).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public todoModel toggleComplete(String id) {
        todoModel todo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        todo.setCompleted(!todo.isCompleted());
        return todoRepo.save(todo);
    }

    public void deleteTodo(String id) {
        todoRepo.deleteById(id);
    }
}