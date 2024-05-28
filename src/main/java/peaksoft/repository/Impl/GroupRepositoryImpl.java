package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.Exception.MyException;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveGroup(Long groupId, List<Course>courses) {
        try {
            Group group = entityManager.find(Group.class, groupId);
            if (group != null) {
                for (Course course : courses) {
                    course.setGroups(getAllGroup());
                    entityManager.persist(course);
                }
            } else {
                System.out.println("Group not found for id: " + groupId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Group getByIdGroup(Long groupId) {
        return  entityManager.find(Group.class, groupId);
    }

    @Override
    public void deleteGroup(Long groupId) {
        Group group = entityManager.find(Group.class, groupId);
        try {
            if (group != null){
                entityManager.remove(group);
            }else {
                throw new MyException("Not fount Id");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Group> getAllGroup() {
        return entityManager.createQuery("select g from Group g",Group.class).getResultList();
    }

    @Override
    public void updateGroup(Long GroupId, Group newgroup) {
        try {
            Group group = entityManager.find(Group.class, GroupId);
            if (group != null) {
                group.setGroupName(newgroup.getGroupName());
                group.setImageLink(newgroup.getImageLink());
                group.setDescription(newgroup.getDescription());
                entityManager.merge(group);
            } else {
                System.out.println("Group not found for id: " + GroupId);
            }
        } catch (Exception e) {
            System.out.println("Error updating group: " + e.getMessage());
        }
    }

    @Override
    public void assignStudentToGroup(Long groupId, Long studentId) {
        try {
            Group group = entityManager.find(Group.class, groupId);
            Student student = entityManager.find(Student.class, studentId);
            if (group != null && student != null) {
                group.getStudents().add(student);
                student.setGroup(group);

                entityManager.merge(group);
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

