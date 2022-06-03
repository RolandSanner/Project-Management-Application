package com.techelevator.dao;

import com.techelevator.model.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getAllProjects();

    Project getAProject(String id);

    void addProject(Project project);

//    Project updateProjectGroupId();

}
