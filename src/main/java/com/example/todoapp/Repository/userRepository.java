package com.example.todoapp.Repository;

import com.example.todoapp.Model.userModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface userRepository extends MongoRepository<userModel, String> {
    // Custom query to find user by username for authentication
    Optional<userModel> findByUsername(String username);

    // Check if email already exists during registration
    Boolean existsByEmail(String email);
}