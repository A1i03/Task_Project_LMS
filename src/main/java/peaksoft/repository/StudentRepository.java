package peaksoft.repository;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentRepository {
    void saveStudent(Student netStudent);

    Student getByIdStudent(Long studentId);

    void deleteStudent(Long studentId);

    List<Student> getAllStudent();

    void updateStudent(Long studentId, Student newStudent);

    void assignStudentToGroup(Long groupId, Long studentId);
}
