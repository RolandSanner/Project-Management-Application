package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class UserController {


    @Autowired
    UserDao userDAO;


    // USER REQUEST MAPPING

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userDAO.findAll();
    }

    @RequestMapping(path = "/users/id/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) {
        return userDAO.getUserById(id);
    }

    @RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        return userDAO.findByUsername(username);
    }




}