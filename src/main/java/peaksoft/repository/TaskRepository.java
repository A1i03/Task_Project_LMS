package peaksoft.repository;

import peaksoft.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void saveTask(Long lessonsId, Task newTask);

    List<Task> getAllTask();

    Task getByIdTask(Long taskId);

    void updateTaskLong(Long TaskId, Task newTask);

    void deleteTask(Long taskId);



}
