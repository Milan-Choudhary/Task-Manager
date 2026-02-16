package com.example.todoapp.Repository;

import com.example.todoapp.Model.userModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface userRepository extends MongoRepository<userModel, String> {

    Optional<userModel> findByUsername(String username);

    Boolean existsByEmail(String email);
}