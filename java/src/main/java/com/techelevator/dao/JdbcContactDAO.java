package com.techelevator.dao;

import com.techelevator.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcContactDAO implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcContactDAO(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    private Contact contactObjectMapper(SqlRowSet results) {

        Contact contact = new Contact();
        contact.setContactID(results.getInt("project_ID"));
        contact.setFirstName(results.getString("first_name"));
        contact.setLastName(results.getString("last_name"));
        contact.setPhoneNumber(results.getString("phone_number"));
        contact.setEmail(results.getString("email"));
        contact.setMunicipality(results.getString("municipality"));
        contact.setContactRole(results.getString("contact_role"));
        contact.setCompanyName(results.getString("companyName"));
        contact.setIndustry(results.getString("industry"));
        contact.setAddress(results.getString("address"));


        return contact;
    }


    @Override
    public List<Contact> listMyProjects(int id) {

        String sql = "SELECT * FROM projects where project_manager_id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);
        List<Contact> project = new ArrayList<>();

        while (results.next()){
            project.add(contactObjectMapper(results));
        }

        return project;
    }
}
