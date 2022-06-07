package com.techelevator.dao;

import com.techelevator.model.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getAllProjects();

    Project getAProject(String id);

    void addProject(Project project);

    void updateProject(Project project);

    List<Project> getProjectsByGroupId(int id);

    void deleteProject(String projectId);
}
