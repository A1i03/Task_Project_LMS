package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.service.InstructorService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor



public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;


    @Override
    public void saveInstructor(Instructor newinstructor) {
        instructorRepository.saveInstructor(newinstructor);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.getAllInstructor();
    }

    @Override
    public Instructor getByIdInstructor(Long instructorId) {
        return instructorRepository.getByIdInstructor(instructorId);
    }

    @Override
    public void updateInstructor(Long instructorId, Instructor newInstructor) {
        instructorRepository.updateInstructor(instructorId,newInstructor);
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        instructorRepository.deleteInstructor(instructorId);
    }

    @Override
    public void assignInstructorToCompany(Long instructorId, Long companyId) {
        instructorRepository.assignInstructorToCompany(instructorId,companyId);
    }
}
