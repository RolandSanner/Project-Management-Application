package com.techelevator.dao;

import com.techelevator.model.Projects;

import java.util.List;

public interface ProjectDAO {

    List<Projects> getAllProjects();

    Projects getAProject(int id);

}
