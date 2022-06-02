package com.techelevator.dao;


import com.techelevator.model.Project;
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


    private Project projectObjectMapper(SqlRowSet results) {

        Project project = new Project();
        project.setProjectID(results.getLong("project_ID"));
        project.setProjectName(results.getString("project_name"));
        project.setPrecinct(results.getString("precinct"));
        project.setMunicipality(results.getString("municipality"));
        project.setLocation(results.getString("location"));
        project.setDescription(results.getString("description"));


        return project;
    }


    @Override
    public List<Project> getAllProjects() {
        String sql = "SELECT * from projects;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Project> projects = new ArrayList<>();
        while (results.next()) {
            projects.add(projectObjectMapper(results));

        }
        return projects;
    }

    @Override
    public Project getAProject(int id) {

        String sql = "SELECT * FROM projects where project_ID = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Project project = null;
        if(results.next()) {
            project = projectObjectMapper(results);
        }

        return project;
    }

    @Override
    public Project addProject() {

        String sql = "INSERT INTO projects (project_id," +
                " project_name," +
                " project_description," +
                " project_location," +
                " precinct," +
                " municipality," +
                " project_manager_id," +
                " group_id) VALUES(?,?,?,?,?,?,?) RETURNING project_id";

        int newProjectID =  jdbcTemplate.queryForObject(sql, Integer.class);


        return getAProject(newProjectID);
    }

    @Override
    public void updateProjectGroupId(int groupId, int projectId){

        String sql = "UPDATE projects SET groups.group_id = ? WHERE projects.project_id = ?";

        jdbcTemplate.update(sql,groupId, projectId);

    }



}
