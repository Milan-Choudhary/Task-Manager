package com.example.todoapp.Repository;

import com.example.todoapp.Model.todoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface todoRepository extends MongoRepository<todoModel,String> {
}
