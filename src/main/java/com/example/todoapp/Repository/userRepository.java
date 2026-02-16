package com.example.todoapp.Repository;

import com.example.todoapp.Model.userModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<userModel,String> {
}
