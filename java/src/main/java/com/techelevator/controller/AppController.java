package com.techelevator.controller;


import com.techelevator.dao.ProjectDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Projects;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AppController {

    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    UserDao userDAO;

    // PROJECT REQUEST MAPPING

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public List<Projects> listProjects() {
        return projectDAO.getAllProjects();
    }

    @RequestMapping(path = "/project/{id}", method = RequestMethod.GET)
    public Projects getProject(@PathVariable int id) {
        return projectDAO.getAProject(id);
    }


    // USER REQUEST MAPPING

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userDAO.findAll();
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) {
        return userDAO.getUserById(id);
    }

    @RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        return userDAO.findByUsername(username);
    }


    // MANAGER REQUEST MAPPING

    @RequestMapping(path = "/managers/{id}", method = RequestMethod.GET)
    public User getMyProjects(@PathVariable String username) {
        return userDAO.findByUsername(username);
    }

}