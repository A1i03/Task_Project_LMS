package peaksoft.repository;


import peaksoft.entity.Course;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupRepository {
    void saveGroup(Long groupId, List<Course>courses);

    Group getByIdGroup(Long groupId);

    void deleteGroup(Long groupId);

    List<Group> getAllGroup();

    void updateGroup(Long GroupId, Group newgroup);

    void assignStudentToGroup(Long groupId, Long studentId);
}
