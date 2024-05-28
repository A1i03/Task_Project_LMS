package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    @Override
    public void saveLesson(Long courseId, Lesson newLesson) {
        lessonRepository.saveLesson(courseId,newLesson);
    }

    @Override
    public Lesson getByIdLesson(Long lessonId) {
        return lessonRepository.getByIdLesson(lessonId);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        lessonRepository.deleteLesson(lessonId);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.getAllLesson();
    }

    @Override
    public void updateLesson(Long LessonId, Lesson newLesson) {
        lessonRepository.updateLesson(LessonId,newLesson);
    }
}
