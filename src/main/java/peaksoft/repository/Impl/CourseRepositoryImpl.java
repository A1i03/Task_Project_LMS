package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.Exception.MyException;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private final  EntityManager entityManager;

    @Override
    public void saveCourse(Long companyId, Course newcourse) {
        Company company = entityManager.find(Company.class, newcourse);
        try {
            if (company != null) {
//                newcourse.setCompany(company);
                company.getCourses().add(newcourse);
                entityManager.merge(company);
            } else {
                System.out.println("Company not found for id: " + companyId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        try {
            if (course != null) {
                entityManager.remove(course);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourse() {
        return entityManager.createQuery("select c from Course c",Course.class).getResultList();
    }

    @Override
    public Course getByIdCourse(Long courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    public void updateCourse(Long CourseId, Course newcourse) {
        Course course = entityManager.find(Course.class, CourseId);
        try {
            if (course != null){
                course.setCourseName(newcourse.getCourseName());
                course.setDateOfStart(newcourse.getDateOfStart());
                course.setDescription(newcourse.getDescription());
                entityManager.merge(course);
            }else {
                throw new MyException("Not Id ");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
