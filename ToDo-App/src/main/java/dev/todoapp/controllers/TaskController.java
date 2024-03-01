package dev.todoapp.controllers;

import dev.todoapp.ToDoApplication;
import dev.todoapp.models.TaskModel;
import dev.todoapp.repositories.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody Map<String, String> payload) {
        TaskModel task = new TaskModel(
                ToDoApplication.currentTimeAsString(),
                payload.get("text"));

        taskRepository.insert(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable ObjectId id) {
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
