package com.techelevator.dao;

import com.techelevator.model.Group;

import java.util.List;

public interface GroupDAO {

    List<Group> getAllGroups();

    Group getGroupById(int groupId);

    void addNewGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(int groupId);

}
