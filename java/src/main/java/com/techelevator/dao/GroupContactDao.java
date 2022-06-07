package com.techelevator.dao;

import com.techelevator.model.GroupContact;

public interface GroupContactDao {
    void addConnection(GroupContact groupContact);

    void changeConnection(GroupContact groupContact);

    void deleteConnection(int groupId, int contactId);
}
