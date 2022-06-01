package com.techelevator.dao;

import com.techelevator.model.Contractor;

import java.util.List;

public interface ContractorDAO {

    List<Contractor> listAllContractors();

    Contractor getAContractorById(int id);

    Contractor addContractor();


}
