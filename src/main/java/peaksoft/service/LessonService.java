package peaksoft.service;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Long courseId, Lesson newLesson);

    Lesson getByIdLesson(Long lessonId);

    void deleteLesson(Long lessonId);

    List<Lesson> getAllLesson();

    void updateLesson(Long LessonId, Lesson newLesson);
}
