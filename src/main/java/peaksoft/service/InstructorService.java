package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {

    void saveInstructor(Instructor newinstructor);

    List<Instructor> getAllInstructor();

    Instructor getByIdInstructor(Long instructorId);

    void updateInstructor(Long instructorId, Instructor newInstructor);

    void deleteInstructor(Long instructorId);

    void assignInstructorToCompany(Long instructorId, Long companyId);
}
