package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    void saveCourse(Course newcourse);
    void deleteCourse(Long courseId);
    List<Course>getAllCourse();
    Optional<Course>getByIdCourse(Long courseId);
    void updateCourse(Long CourseId, Course newcourse);
}
