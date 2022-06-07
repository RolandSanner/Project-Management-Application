package com.techelevator.dao;

import com.techelevator.model.ProjectContractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcProjectContractorDAO implements ProjectContractorDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcProjectContractorDAO(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }


    @Override
    public void addConnection(ProjectContractor projectContractor) {
        String sql="INSERT INTO project_contractors (contractor_id,project_id) " +
                "VALUES (?,?);";
        jdbcTemplate.update(sql,projectContractor.getContractor_id(),projectContractor.getProject_id());
    }

    @Override
    public void changeConnection(ProjectContractor projectContractor) {
        String sql="UPDATE project_contractors SET project_id=? WHERE contractor_id=?;";
        jdbcTemplate.update(sql,projectContractor.getProject_id(),projectContractor.getContractor_id());
    }

    @Override
    public void deleteConnection(ProjectContractor projectContractor) {
        String sql="DELETE FROM project_contractors WHERE project_id=? AND contractor_id=?";
        jdbcTemplate.update(sql,projectContractor.getProject_id(),projectContractor.getContractor_id());
    }
}
