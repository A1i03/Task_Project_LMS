package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    @Override
    public void saveCourse(Long companyId, Course newcourse) {
        courseRepository.saveCourse(companyId,newcourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteCourse(courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course getByIdCourse(Long courseId) {
        return courseRepository.getByIdCourse(courseId);
    }

    @Override
    public void updateCourse(Long CourseId, Course newcourse) {
        courseRepository.updateCourse(CourseId,newcourse);
    }
}
