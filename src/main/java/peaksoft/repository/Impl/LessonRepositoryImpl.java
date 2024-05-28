package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class LessonRepositoryImpl implements LessonRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveLesson(Long courseId, Lesson newLesson) {
        try {
            Course course = entityManager.find(Course.class, courseId);
            if (course != null) {
                course.getLessons().add(newLesson);
                newLesson.setCourse(course);
                entityManager.merge(course);
            } else {
                System.out.println("Course not found for id: " + courseId);
            }
        } catch (Exception e) {
            System.out.println("Error saving lesson: " + e.getMessage());
        }
    }

    @Override
    public Lesson getByIdLesson(Long lessonId) {
        return  entityManager.find(Lesson.class, lessonId);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        try {
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            if (lesson != null) {
                entityManager.remove(lesson);
            } else {
                System.out.println("Lesson not found for id: " + lessonId);
            }
        } catch (Exception e) {
            System.out.println("Error deleting lesson: " + e.getMessage());
        }
    }

    @Override
    public List<Lesson> getAllLesson() {
        return entityManager.createQuery("select l from Lesson l",Lesson.class).getResultList();
    }

        @Override
        public void updateLesson(Long LessonId, Lesson newLesson) {
            try {
                Lesson existingLesson = entityManager.find(Lesson.class, LessonId);

                if (existingLesson != null) {
                    existingLesson.setLessonName(newLesson.getLessonName());
                    entityManager.merge(existingLesson);
                } else {
                    System.out.println("Lesson not found for id: " + LessonId);
                }
            } catch (Exception e) {
                System.out.println("Error updating lesson: " + e.getMessage());
            }
        }
        }

