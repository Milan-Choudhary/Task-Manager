# Task Manager

A full-stack task management web application built with Spring Boot 4 and MongoDB. Features a clean, modern UI for creating, completing, and deleting tasks.

## Tech Stack

- **Backend:** Java 17, Spring Boot 4.0.2
- **Database:** MongoDB
- **Template Engine:** Thymeleaf
- **Validation:** Jakarta Bean Validation
- **Build Tool:** Maven (with Maven Wrapper)
- **Other:** Lombok

## Project Structure

```
src/main/java/com/example/todoapp/
├── Controller/       # MVC controllers (todoController)
├── DTO/              # Data Transfer Objects (request/response records)
├── Model/            # MongoDB document models (todoModel, userModel)
├── Repository/       # Spring Data MongoDB repositories
├── Service/          # Business logic layer
└── TodoAppApplication.java

src/main/resources/
├── application.properties   # App configuration
├── static/css/style.css     # Styling
└── templates/todo-list.html # Thymeleaf template
```

## Prerequisites

- Java 17+
- MongoDB running on `localhost:27017`

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Milan-Choudhary/Task-Manager.git
   cd Task-Manager
   ```

2. **Start MongoDB:**
   ```bash
   mongod
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Open in browser:**
   ```
   http://localhost:8080/todos
   ```

## Features

- **Add tasks** with a title and optional description
- **Mark tasks as complete** (toggle done/undo)
- **Delete tasks**
- **Validation** — title is required (3–100 characters)
- **Separate views** for pending and completed tasks
- **User model** ready for future authentication (registration & login DTOs scaffolded)

## API Endpoints

| Method | Path                | Description            |
|--------|---------------------|------------------------|
| GET    | `/todos`            | Show task list page    |
| POST   | `/todos/save`       | Create a new task      |
| GET    | `/todos/toggle/{id}`| Toggle task completion |
| GET    | `/todos/delete/{id}`| Delete a task          |

## Configuration

Key settings in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/todo_db
server.port=8080
```

## Running Tests

```bash
./mvnw test
```

## License

This project is open source.
