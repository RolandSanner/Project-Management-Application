package com.techelevator.controller;


import com.techelevator.dao.ProjectDAO;
import com.techelevator.model.Projects;
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

    @RequestMapping(path="/projects", method = RequestMethod.GET)
    public List<Projects> listProjects(){
        return projectDAO.getAllProjects();
    }

    @RequestMapping(path="/flight/{id}", method = RequestMethod.GET)
    public Projects getProject(@PathVariable int id) {
        return projectDAO.getAProject(id);
    }

}
