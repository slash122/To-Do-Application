package dev.todoapp.repositories;

import org.bson.types.ObjectId;
import dev.todoapp.models.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel, ObjectId> {
}
