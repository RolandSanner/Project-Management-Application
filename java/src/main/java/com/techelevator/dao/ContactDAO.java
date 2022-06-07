package com.techelevator.dao;

import com.techelevator.model.Contact;
import com.techelevator.model.Project;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

public interface ContactDAO {

    List<Contact> listMyProjects(int id);

    void addContact(Contact contact);

    List<Contact> getAllContacts();

    List<Contact> getContactsByGroupId(int id);

    List<Contact> getContractorsByProjectId(String id);

    void updateContact(Contact contact);

    void deleteContact(int contactId);

    Contact getContactByID(int id);
}
