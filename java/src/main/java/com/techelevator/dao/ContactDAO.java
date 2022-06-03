package com.techelevator.dao;

import com.techelevator.model.Contact;


import java.util.List;

public interface ContactDAO {


    List<Contact> listMyProjects(int id);

    void addContact(Contact contact);

    List<Contact> getAllContacts();

}
