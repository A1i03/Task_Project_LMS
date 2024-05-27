package peaksoft.repository;


import peaksoft.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository {
    void  saveInstructor(Instructor newinstructor);
    List<Instructor>getAllInstructor();
    Optional<Instructor>getByIdInstructor(Long instructorId);
    void updateInstructor(Long instructorId, Instructor newInstructor);
    void deleteInstructor(Long instructorId);
}
