package com.example.todoapp.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "to_do_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userModel {

    @Id
    private String id;

    @NotBlank(message = "Username is required")
    @Indexed(unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Indexed(unique = true)
    private String email;
}