package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public void saveStudent(Student netStudent) {
        studentRepository.saveStudent(netStudent);
    }
    @Override
    public Student getByIdStudent(Long studentId) {
        return studentRepository.getByIdStudent(studentId);
    }
    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteStudent(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        studentRepository.updateStudent(studentId,newStudent);
    }

    @Override
    public void assignStudentToGroup(Long groupId, Long studentId) {
        studentRepository.assignStudentToGroup(groupId,studentId);
    }
}
