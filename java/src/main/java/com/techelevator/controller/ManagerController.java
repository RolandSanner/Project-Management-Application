package com.techelevator.controller;

import com.techelevator.dao.ManagerDAO;
import com.techelevator.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ManagerController {

    @Autowired
    ManagerDAO managerDAO;


    // MANAGER REQUEST MAPPING

    @RequestMapping(path = "/manager/{id}", method = RequestMethod.GET)
    public List<Manager> listManagerProjects(@PathVariable int id) {
        return managerDAO.listMyProjects(id);
    }


}
