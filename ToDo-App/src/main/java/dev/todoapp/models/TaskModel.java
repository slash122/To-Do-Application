package dev.todoapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {
    public TaskModel(String _createdTime, String _text) {
        createdTime = _createdTime;
        text = _text;
    }

    @Id
    private ObjectId id;

    private String createdTime;

    private String text;
}
