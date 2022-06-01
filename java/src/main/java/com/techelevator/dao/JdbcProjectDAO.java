package com.techelevator.dao;


import com.techelevator.model.Projects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProjectDAO implements ProjectDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcProjectDAO(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    private Projects projectObjectMapper(SqlRowSet results) {

        Projects project = new Projects();
        project.setProjectID(results.getLong("project_ID"));
        project.setProjectName(results.getString("project_name"));
        project.setPrecinct(results.getString("precinct"));
        project.setMunicipality(results.getString("municipality"));
        project.setLocation(results.getString("location"));
        project.setDescription(results.getString("description"));


        return project;
    }


    @Override
    public List<Projects> getAllProjects() {
        String sql = "SELECT * from projects;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Projects> projects = new ArrayList<>();
        while (results.next()) {
            projects.add(projectObjectMapper(results));

        }
        return projects;
    }

    @Override
    public Projects getAProject(int id) {

        String sql = "SELECT * FROM projects where project_ID = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Projects project = null;
        if(results.next()) {
            project = projectObjectMapper(results);
        }

        return project;
    }

    @Override
    public Projects getMyProjects(int id) {

        String sql = "SELECT * FROM projects where manager_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Projects project = null;
        if(results.next()) {
            project = projectObjectMapper(results);
        }

        return project;
    }


}
