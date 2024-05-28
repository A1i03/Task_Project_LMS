package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveStudent(Student netStudent) {
        try {
            Student student = entityManager.find(Student.class, netStudent);
            if (student != null) {
                student.setFirstName(netStudent.getFirstName());
                student.setLastName(netStudent.getLastName());
                student.setPhoneNumber(netStudent.getPhoneNumber());
                student.setEmail(netStudent.getEmail());
                student.setStudyFormat(netStudent.getStudyFormat());
                entityManager.merge(student);
            } else {
                entityManager.persist(netStudent);
            }
        } catch (Exception e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }


    @Override
    public Student getByIdStudent(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public void deleteStudent(Long studentId) {
        entityManager.remove(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        try {
            Student existingStudent = entityManager.find(Student.class, studentId);

            if (existingStudent != null) {
                existingStudent.setFirstName(newStudent.getFirstName());
                existingStudent.setLastName(newStudent.getLastName());
                existingStudent.setPhoneNumber(newStudent.getPhoneNumber());
                existingStudent.setEmail(newStudent.getEmail());
                existingStudent.setStudyFormat(newStudent.getStudyFormat());
                entityManager.merge(existingStudent);
            } else {
                System.out.println("Student not found for id: " + studentId);
            }
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }


    @Override
    public void assignStudentToGroup(Long groupId, Long studentId) {
        try {
            Group group = entityManager.find(Group.class, groupId);
            Student student = entityManager.find(Student.class, studentId);

            if (group != null && student != null) {

                student.setGroup(group);
                entityManager.merge(student);

                System.out.println("Student successfully assigned to group.");
            } else {
                System.out.println("Group or student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error assigning student to group: " + e.getMessage());
        }
    }
    }

