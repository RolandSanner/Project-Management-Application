package com.techelevator.dao;

import com.techelevator.model.ProjectContractor;

public interface ProjectContractorDAO {
    void addConnection(ProjectContractor projectContractor);

    void changeConnection(ProjectContractor projectContractor);

    void deleteConnection(ProjectContractor projectContractor);
}
