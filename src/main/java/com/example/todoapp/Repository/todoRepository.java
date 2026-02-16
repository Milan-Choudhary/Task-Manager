package com.example.todoapp.Repository;

import com.example.todoapp.Model.todoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface todoRepository extends MongoRepository<todoModel, String> {

    // Find all todos created by a specific user
    List<todoModel> findByUserId(String userId);

    // Find only completed or pending tasks for a specific user
    List<todoModel> findByUserIdAndCompleted(String userId, boolean completed);
}