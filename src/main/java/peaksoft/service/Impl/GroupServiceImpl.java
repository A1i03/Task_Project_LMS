package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;


    @Override
    public void saveGroup(Long groupId, List<Course> courses) {
        groupRepository.saveGroup(groupId,courses);
    }

    @Override
    public Group getByIdGroup(Long groupId) {
        return groupRepository.getByIdGroup(groupId);
    }

    @Override
    public void deleteGroup(Long groupId) {
    groupRepository.deleteGroup(groupId);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.getAllGroup();
    }

    @Override
    public void updateGroup(Long GroupId, Group newgroup) {
        groupRepository.updateGroup(GroupId,newgroup);
    }

    @Override
    public void assignStudentToGroup(Long groupId, Long studentId) {
        groupRepository.assignStudentToGroup(groupId,studentId);
    }
}
