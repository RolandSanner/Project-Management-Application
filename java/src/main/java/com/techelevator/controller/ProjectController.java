package com.techelevator.controller;

import com.techelevator.dao.ProjectDAO;
import com.techelevator.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
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
    public Project getProject(@PathVariable String id) {
        return projectDAO.getAProject(id);
    }

    @RequestMapping(path="/project/new", method=RequestMethod.POST)
    public void addProject(@RequestBody Project project) {
       projectDAO.addProject(project);
    }

//    @RequestMapping(path="project/{groupId}/updateGroup", method = RequestMethod.PUT)
//    public void updateProjectGroupId(@PathVariable int id, @RequestBody Project project){
//        project.setGroupID(id);
//        projectDAO.updateProjectGroupId();
//    }

    @RequestMapping(path = "groups/{id}/projects", method = RequestMethod.GET)
    public List<Project> getProjectsByGroupId(@PathVariable int id){
        return projectDAO.getProjectsByGroupId(id);
    }
}
