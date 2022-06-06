package com.techelevator.controller;

import com.techelevator.dao.ContactDAO;
import com.techelevator.model.Contact;
import com.techelevator.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ContactController {

    @Autowired
    ContactDAO contactDAO;


    // CONTACT REQUEST MAPPING

    @RequestMapping(path = "/manager/{id}", method = RequestMethod.GET)
    public List<Contact> listManagerProjects(@PathVariable int id) {
        return contactDAO.listMyProjects(id);
    }

    @RequestMapping(path="/contacts/new", method = RequestMethod.POST)
    public void addContact(@RequestBody Contact contact){
        contactDAO.addContact(contact);
    }

    @RequestMapping(path = "/contacts", method = RequestMethod.GET)
    public List<Contact> listContacts() {return contactDAO.getAllContacts();}

}
