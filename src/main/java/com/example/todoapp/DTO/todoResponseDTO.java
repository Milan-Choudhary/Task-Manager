package com.example.todoapp.DTO;

import java.time.LocalDateTime;

public record todoResponseDTO(
        String id,
        String title,
        String description,
        boolean completed,
        LocalDateTime createdAt
) {}