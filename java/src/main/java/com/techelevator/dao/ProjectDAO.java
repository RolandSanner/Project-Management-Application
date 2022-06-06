package com.techelevator.dao;

import com.techelevator.model.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getAllProjects();

    Project getAProject(String id);

    void addProject(Project project);

//    Project updateProjectGroupId();

    List<Project> getProjectsByGroupId(int id);

    List<Project> getProjectsByContractorID(int id);
}
