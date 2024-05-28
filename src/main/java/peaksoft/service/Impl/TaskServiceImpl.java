package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public void saveTask(Long lessonsId, Task newTask) {
    taskRepository.saveTask(lessonsId,newTask);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.getAllTask();
    }

    @Override
    public Task getByIdTask(Long taskId) {
        return taskRepository.getByIdTask(taskId);
    }

    @Override
    public void updateTaskLong(Long TaskId, Task newTask) {
        taskRepository.updateTaskLong(TaskId,newTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteTask(taskId);
    }
}
