package peaksoft.repository;


import peaksoft.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonRepository {
    void saveLesson(Lesson newLesson);
    Optional<Lesson>getByIdLesson(Long lessonId);
    void deleteLesson(Long lessonId);
    List<Lesson>getAllLesson();
    void updateLesson(Long LessonId, Lesson newLesson);
}
