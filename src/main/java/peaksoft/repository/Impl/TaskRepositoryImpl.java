package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveTask(Long lessonsId, Task newTask) {
        try {
            Lesson lesson = entityManager.find(Lesson.class, lessonsId);
            if (lesson != null) {
                newTask.setLesson(lesson);
                entityManager.persist(newTask);
            } else {
                System.out.println("Lesson not found for id: " + lessonsId);
            }
        } catch (Exception e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    @Override
    public List<Task> getAllTask() {
        return entityManager.createQuery("select t from Task t",Task.class).getResultList();
    }

    @Override
    public Task getByIdTask(Long taskId) {
       return entityManager.find(Task.class, taskId);
        }

    @Override
    public void updateTaskLong(Long TaskId, Task newTask) {
        try {
            Task existingTask = entityManager.find(Task.class, TaskId);
            if (existingTask != null) {
                existingTask.setTaskName(newTask.getTaskName());
                existingTask.setTaskText(newTask.getTaskText());
                existingTask.setDeadLine(newTask.getDeadLine());
                entityManager.merge(existingTask);
            } else {
                System.out.println("Task not found for id: " + TaskId);
            }
        } catch (Exception e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        try {
        Task task = entityManager.find(Task.class, taskId);
        if (task != null){
            entityManager.remove(task);
        } else {
            System.out.println("Lesson not found for id: " + taskId);
        }
        } catch (Exception e) {
            System.out.println("Error deleting lesson: " + e.getMessage());
        }

    }
}
