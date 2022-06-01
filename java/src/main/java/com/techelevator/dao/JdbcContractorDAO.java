package com.techelevator.dao;

import com.techelevator.model.Contractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcContractorDAO implements ContractorDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcContractorDAO(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private Contractor contractorObjectMapper(SqlRowSet results) {

        Contractor contractors = new Contractor();
        contractors.setContractorID(results.getInt("contractor_ID"));
        contractors.setFirstName(results.getString("firstName"));
        contractors.setLastName(results.getString("lastName"));
        contractors.setPhoneNumber(results.getString("phoneNumber"));
        contractors.setEmail(results.getString("email"));
        contractors.setCompanyName(results.getString("companyName"));
        contractors.setIndustry(results.getString("industry"));
        contractors.setContractorAddress(results.getString("contractor_address"));

        return contractors;
    }
    public Contractor getAContractorById(int id) {

        String sql = "SELECT * FROM contractors where contractor_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Contractor contractor = null;
        if(results.next()) {
            contractor = contractorObjectMapper(results);
        }

        return contractor;
    }


    @Override
    public List<Contractor> listAllContractors() {

        String sql = "SELECT * FROM contractors";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Contractor> contractors = new ArrayList<>();

        while (results.next()){
            contractors.add(contractorObjectMapper(results));
        }

        return contractors;
    }

    @Override
    public Contractor addContractor() {

        String sql = "INSERT INTO contractors (contractor_id," +
                " firstName," +
                " lastName," +
                " phoneNumber," +
                " email," +
                " companyName," +
                " industry," +
                " contractor_address) VALUES(?,?,?,?,?,?,?) RETURNING contractor_id";

        int newContractorID =  jdbcTemplate.queryForObject(sql, Integer.class);


        return getAContractorById(newContractorID);
    }


}
