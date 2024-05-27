package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void saveStudent(Student netStudent);
    Optional<Student>getByIdStudent(Long studentId);
    void deleteStudent(Long studentId);
    List<Student>getAllStudent();
    void updateStudent(Long studentId, Student newStudent);
}
