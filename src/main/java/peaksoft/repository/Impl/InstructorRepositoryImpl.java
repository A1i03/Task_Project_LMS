package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class InstructorRepositoryImpl  implements InstructorRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveInstructor(Instructor newinstructor) {
        try {
            entityManager.persist(newinstructor);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return entityManager.createQuery("select i from Instructor i",Instructor.class).getResultList();
    }

    @Override
    public Instructor getByIdInstructor(Long instructorId) {
        return entityManager.find(Instructor.class, instructorId);

    }

    @Override
    public void updateInstructor(Long instructorId, Instructor newInstructor) {
        try {
            Instructor existingInstructor = entityManager.find(Instructor.class, instructorId);

            if (existingInstructor != null) {
                existingInstructor.setFirstName(newInstructor.getFirstName());
                existingInstructor.setLastName(newInstructor.getLastName());
                existingInstructor.setPhoneNumber(newInstructor.getPhoneNumber());
                existingInstructor.setSpecialization(newInstructor.getSpecialization());
                entityManager.merge(existingInstructor);
            } else {
                System.out.println("Instructor not found for id: " + instructorId);
            }
        } catch (Exception e) {
            System.out.println("Error updating instructor: " + e.getMessage());
        }
    }


    @Override
    public void deleteInstructor(Long instructorId) {
        try {
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            if (instructor != null) {
                entityManager.remove(instructor);
            } else {
                System.out.println("Instructor not found for id: " + instructorId);
            }
        } catch (Exception e) {
            System.out.println("Error deleting instructor: " + e.getMessage());
        }
    }



    @Override
    public void assignInstructorToCompany(Long instructorId, Long companyId) {
        try {
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            Company company = entityManager.find(Company.class, companyId);
            if (instructor != null && company != null) {
                entityManager.merge(instructor);

                System.out.println("Instructor successfully assigned to company.");
            } else {
                System.out.println("Instructor or company not found.");
            }
        } catch (Exception e) {
            System.out.println("Error assigning instructor to company: " + e.getMessage());
        }
    }
    }

