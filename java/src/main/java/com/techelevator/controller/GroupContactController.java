package com.techelevator.controller;

import com.techelevator.dao.GroupContactDao;
import com.techelevator.model.GroupContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class GroupContactController {

    @Autowired
    GroupContactDao groupContactDao;

    @RequestMapping(path="/contact/assignGroup",method = RequestMethod.POST)
    public void assignContactToGroup(@RequestBody GroupContact groupContact){
        groupContactDao.addConnection(groupContact);
    }

    @RequestMapping(path = "/contact/reassignGroup",method = RequestMethod.PUT)
    public void changeGroupAssignment(@RequestBody GroupContact groupContact){
        groupContactDao.changeConnection(groupContact);
    }

    @RequestMapping(path = "/contact/unassignFromGroup",method = RequestMethod.DELETE)
    public void unassignContactFromGroup(@RequestBody GroupContact groupContact){
        groupContactDao.deleteConnection(groupContact.getGroup_id(),groupContact.getContact_id());
    }

}
