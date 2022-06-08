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
        project.setContractName(results.getString("contractname"));
        project.setFundingSource(results.getString("fundingsource"));

        return project;
    }

    private Project projectObjectMapperWithName(SqlRowSet results) {

        Project project = new Project();
        project.setProjectID(results.getString("project_id"));
        project.setProjectName(results.getString("project_name"));
        project.setPrecinct(results.getString("precinct"));
        project.setMunicipality(results.getString("municipality"));
        project.setLocation(results.getString("project_location"));
        project.setDescription(results.getString("project_description"));
        project.setGroupID(results.getLong("group_id"));
        project.setProjectManagerID(results.getLong("project_manager_id"));
        project.setContractName(results.getString("contractname"));
        project.setFundingSource(results.getString("fundingsource"));
        project.setProjectManagerName(results.getString("project_manager_name"));
        project.setGroupName(results.getString("group_name"));


        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        String sql = "SELECT project_id,project_name,project_description,project_location,precinct,A.municipality,project_manager_id,A.group_id,group_name,contractname,fundingsource,CONCAT(firstname, ' ',lastname) AS project_manager_name " +
                " FROM projects A " +
                "JOIN contacts B ON A.project_manager_id=B.contact_id " +
                "JOIN groups C ON A.group_id=C.group_id;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Project> projects = new ArrayList<>();
        while (results.next()) {
            projects.add(projectObjectMapperWithName(results));

        }
        return projects;
    }

    @Override
    public Project getAProject(String id) {

        String sql = "SELECT project_id,project_name,project_description,project_location,precinct,A.municipality,project_manager_id,A.group_id,group_name,contractname,fundingsource,CONCAT(firstname, ' ',lastname) AS project_manager_name " +
                "FROM projects A " +
                "JOIN contacts B ON A.project_manager_id=B.contact_id " +
                "JOIN groups C ON A.group_id=C.group_id "+
                " where project_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        Project project = null;
        if(results.next()) {
            project = projectObjectMapperWithName(results);
        }

        return project;
    }

    @Override
    public void addProject(Project project) {

        String sql = "INSERT INTO projects (project_id, project_name, project_description, project_location, precinct, municipality, project_manager_id, group_id, contractName, fundingSource) VALUES(?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, project.getProjectID(),project.getProjectName(),project.getDescription(),project.getLocation(),project.getPrecinct(),project.getMunicipality(),project.getProjectManagerID(),project.getGroupID(), project.getContractName(), project.getFundingSource());

    }

    @Override
    public void updateProject(Project project) {
        String sql="UPDATE projects SET project_name=?,project_description=?,project_location=?,precinct=?,municipality=?,project_manager_id=?,group_id=?,contractname=?,fundingsource=? " +
                "WHERE project_id=?";
        jdbcTemplate.update(sql,project.getProjectName(),project.getDescription(),project.getLocation(),project.getPrecinct(),project.getMunicipality(),project.getProjectManagerID(),project.getGroupID(),project.getContractName(),project.getFundingSource(),project.getProjectID());
    }

    @Override
    public List<Project> getProjectsByGroupId(int id) {
        String sql="SELECT project_id,project_name,project_description,project_location,precinct,A.municipality,project_manager_id,A.group_id,group_name,contractname,fundingsource,CONCAT(firstname, ' ',lastname) AS project_manager_name" +
                " FROM projects A " +
                "JOIN contacts B ON A.project_manager_id=B.contact_id " +
                "JOIN groups C ON A.group_id=C.group_id"+
                " WHERE A.group_id=?";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql,id);
        List<Project>projects=new ArrayList<>();
        while (results.next()){
            projects.add(projectObjectMapperWithName(results));
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByContractorID(int id) {
        String sql = "SELECT *\n" +
                "FROM projects\n" +
                "JOIN project_contractors pc on projects.project_id = pc.project_id\n" +
                "WHERE contractor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        List<Project> projects = new ArrayList<>();
        while (results.next()){
            projects.add(projectObjectMapper(results));
        }
        return projects;
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


    public void deleteProject(String projectId) {
        String sql="DELETE FROM projects WHERE project_id=?";
        jdbcTemplate.update(sql,projectId);
    }

}
