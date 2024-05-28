package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Long companyId, Course newcourse);

    void deleteCourse(Long courseId);

    List<Course> getAllCourse();

    Course getByIdCourse(Long courseId);

    void updateCourse(Long CourseId, Course newcourse);
}
