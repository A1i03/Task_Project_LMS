package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Long companyId, Course newcourse);

    void deleteCourse(Long courseId);

    List<Course> getAllCourse();

    Course getByIdCourse(Long courseId);

    void updateCourse(Long CourseId, Course newcourse);
}
