package com.techelevator.controller;

import com.techelevator.dao.GroupDAO;
import com.techelevator.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class GroupController {

    @Autowired
    GroupDAO groupDAO;

    @RequestMapping(path = "/groups", method = RequestMethod.GET)
    public List<Group> listGroups() {
        return groupDAO.getAllGroups();
    }

    @RequestMapping(path = "/groups/{id}",method = RequestMethod.GET)
    public Group getGroupById(@PathVariable int id){
        return groupDAO.getGroupById(id);
    }

    @RequestMapping(path = "/groups/new",method = RequestMethod.POST)
    public void addGroup(@RequestBody Group group){
        groupDAO.addNewGroup(group);
    }





}
