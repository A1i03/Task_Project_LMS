package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {
    void saveGroup(Long groupId, List<Course> courses);

    Group getByIdGroup(Long groupId);

    void deleteGroup(Long groupId);

    List<Group> getAllGroup();

    void updateGroup(Long GroupId, Group newgroup);

    void assignStudentToGroup(Long groupId, Long studentId);
}
