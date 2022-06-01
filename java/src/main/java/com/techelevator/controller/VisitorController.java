package com.techelevator.controller;

import com.techelevator.dao.VisitorDAO;
import com.techelevator.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class VisitorController {

    @Autowired
    VisitorDAO visitorDAO;

    // CONTRACTOR REQUEST MAPPING

    @RequestMapping(path = "/visitor", method = RequestMethod.GET)
    public List<Visitor> listAllVisitors() {
        return visitorDAO.listAllVisitors();
    }


}
