package com.example.todoapp.Repository;

import com.example.todoapp.Model.todoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface todoRepository extends MongoRepository<todoModel, String> {


    List<todoModel> findByUserId(String userId);

    List<todoModel> findByUserIdAndCompleted(String userId, boolean completed);
}