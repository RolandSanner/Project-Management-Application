package com.techelevator.controller;

import com.techelevator.dao.ProjectDAO;
import com.techelevator.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProjectController {


    @Autowired
    ProjectDAO projectDAO;

    // PROJECT REQUEST MAPPING

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public List<Project> listProjects() {
        return projectDAO.getAllProjects();
    }

    @RequestMapping(path = "/project/{id}", method = RequestMethod.GET)
    public Project getProject(@PathVariable int id) {
        return projectDAO.getAProject(id);
    }

    @RequestMapping(path="/project/new", method=RequestMethod.POST)
    public Project addProject(@RequestBody ProjectDAO projectDAO) {
        return projectDAO.addProject();
    }

}
