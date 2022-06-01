package com.techelevator.controller;


import com.techelevator.dao.ContractorDAO;
import com.techelevator.model.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ContractorController {

    @Autowired
    ContractorDAO contractorDAO;

    // CONTRACTOR REQUEST MAPPING

    @RequestMapping(path = "/contractor", method = RequestMethod.GET)
    public List<Contractor> listAllContractors() {
        return contractorDAO.listAllContractors();
    }

    @RequestMapping(path = "/contractor/{id}", method = RequestMethod.GET)
    public Contractor getAContractorById(@PathVariable int id) {
        return contractorDAO.getAContractorById(id);
    }

    @RequestMapping(path="/contractor/new", method=RequestMethod.POST)
    public Contractor addContractor(@RequestBody ContractorDAO contractorDAO) {
        return contractorDAO.addContractor();
    }



}
