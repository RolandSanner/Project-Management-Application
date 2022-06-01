package com.techelevator.dao;

import com.techelevator.model.Managers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcManagerDAO implements ManagerDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcManagerDAO(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    private Managers managerObjectMapper(SqlRowSet results) {

        Managers managers = new Managers();
        managers.setManagerID(results.getInt("project_ID"));
        managers.setFirstName(results.getString("first_name"));
        managers.setLastName(results.getString("last_name"));
        managers.setPhoneNumber(results.getString("phone_number"));
        managers.setEmail(results.getString("email"));
        managers.setMunicipality(results.getString("municipality"));
        managers.setManagerRole(results.getString("manager_role"));

        return managers;
    }


    @Override
    public List<Managers> listMyProjects(int id) {

        String sql = "SELECT * FROM projects where project_manager_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);
        List<Managers> project = new ArrayList<>();

        while (results.next()){
            project.add(managerObjectMapper(results));
        }

        return project;
    }
}
