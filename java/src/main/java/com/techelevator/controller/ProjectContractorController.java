package com.techelevator.controller;

import com.techelevator.dao.ProjectContractorDAO;
import com.techelevator.model.ProjectContractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProjectContractorController {

    @Autowired
    ProjectContractorDAO projectContractorDAO;

    @RequestMapping(path="/contractor/assignProject",method = RequestMethod.POST)
    public void assignContractorToProject(@RequestBody ProjectContractor projectContractor){
        projectContractorDAO.addConnection(projectContractor);
    }

    @RequestMapping(path = "/contractor/reassignProject",method = RequestMethod.PUT)
    public void changeContractorAssignment(@RequestBody ProjectContractor projectContractor){
        projectContractorDAO.changeConnection(projectContractor);
    }

    @RequestMapping(path = "/contractor/unassignFromProject",method = RequestMethod.DELETE)
    public void unassignContractorFromProject(@RequestBody ProjectContractor projectContractor){
        projectContractorDAO.deleteConnection(projectContractor);
    }

}
