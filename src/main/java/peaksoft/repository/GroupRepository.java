package peaksoft.repository;


import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    void saveGroup(Group newgroup);
    Optional<Group>getByIdGroup(Long groupId);
    void deleteGroup(Long groupId);
    List<Group>getAllGroup();
    void updateGroup(Long GroupId, Group newgroup);
}
