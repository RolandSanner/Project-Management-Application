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
        project.setProjectID(results.getString("project_id"));
        project.setProjectName(results.getString("project_name"));
        project.setPrecinct(results.getString("precinct"));
        project.setMunicipality(results.getString("municipality"));
        project.setLocation(results.getString("project_location"));
        project.setDescription(results.getString("project_description"));
        project.setGroupID(results.getLong("group_id"));
        project.setProjectManagerID(results.getLong("project_manager_id"));


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
    public Project getAProject(String id) {

        String sql = "SELECT * FROM projects where project_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Project project = null;
        if(results.next()) {
            project = projectObjectMapper(results);
        }

        return project;
    }

    @Override
    public void addProject(Project project) {

        String sql = "INSERT INTO projects (project_id, project_name, project_description, project_location, precinct, municipality, project_manager_id, group_id, contractname, fundingsource) VALUES(?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, project.getProjectID(),project.getProjectName(),project.getDescription(),project.getLocation(),project.getPrecinct(),project.getMunicipality(),project.getProjectManagerID(),project.getGroupID(), project.getContractName(), project.getFundingSource());

    }

//    @Override
//    public void updateProjectGroupID(int groupID, int projectID){
//
//        String sql = "UPDATE projects SET group_id = ? WHERE projects.project_id = ?";
//        String sql2 = "UPDATE groups SET group_id = ? WHERE projects.project_id = ?";
//
//        jdbcTemplate.update(sql, sql2, groupID, projectID);
//
//    }



}
