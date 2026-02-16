package com.example.todoapp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record todoRequestDTO(
        @NotBlank(message = "Task title is required")
        @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
        String title,

        String description
) {}