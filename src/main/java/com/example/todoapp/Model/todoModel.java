package com.example.todoapp.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class todoModel {

    @Id
    private String id;

    @NotBlank(message = "User reference is required")
    private String userId;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String description;

    private boolean completed = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}