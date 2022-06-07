package com.techelevator.dao;

import com.techelevator.model.Contact;
import com.techelevator.model.Project;
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
        contact.setContactID(results.getInt("contact_id"));
        contact.setFirstName(results.getString("firstname"));
        contact.setLastName(results.getString("lastname"));
        contact.setPhoneNumber(results.getString("phonenumber"));
        contact.setEmail(results.getString("email"));
        contact.setMunicipality(results.getString("municipality"));
        contact.setContactRole(results.getString("contact_role"));
        contact.setCompanyName(results.getString("companyName"));
        contact.setIndustry(results.getString("industry"));
        contact.setContactCity(results.getString("contact_city"));
        contact.setContactState(results.getString("contact_state"));
        contact.setContactStreet(results.getString("contact_street"));
        contact.setContactZip(results.getString("contact_zip"));

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

    @Override
    public void addContact(Contact contact){
        String sql = "INSERT INTO contacts (firstName, lastName, phoneNumber, email, municipality, contact_role, companyName, industry, contact_street, contact_city, contact_state, contact_zip)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail(), contact.getMunicipality(), contact.getContactRole(), contact.getCompanyName(), contact.getIndustry(), contact.getContactStreet(), contact.getContactCity(), contact.getContactState(), contact.getContactZip());
    }

    @Override
    public List<Contact> getAllContacts() {
        String sql = "SELECT * from contacts;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Contact> contacts = new ArrayList<>();
        while (results.next()) {
            contacts.add(contactObjectMapper(results));

        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByGroupId(int id) {
        String sql="SELECT* FROM contacts A  JOIN group_contacts B ON A.contact_id=B.contact_id  WHERE B.group_id=?";
        SqlRowSet results=this.jdbcTemplate.queryForRowSet(sql,id);
        List<Contact> contacts=new ArrayList<>();
        while (results.next()){
            contacts.add(contactObjectMapper(results));
        }
        return contacts;
    }

    @Override
    public List<Contact> getContractorsByProjectId(String id) {
        String sql="SELECT* FROM contacts A JOIN project_contractors B ON A.contact_id=B.contractor_id WHERE B.project_id=? AND A.contact_role='Contractor'";
        SqlRowSet results=this.jdbcTemplate.queryForRowSet(sql,id);
        List<Contact> contacts=new ArrayList<>();
        while (results.next()){
            contacts.add(contactObjectMapper(results));
        }
        return contacts;
    }

    @Override
    public void updateContact(Contact contact) {
        String sql="UPDATE contacts SET firstname=?,lastname=?,phonenumber=?,email=?,municipality=?,contact_role=?,companyname=?,industry=?,contact_street=?,contact_city=?,contact_state=?,contact_zip=? " +
                "WHERE contact_id=?";
        jdbcTemplate.update(sql,contact.getFirstName(),contact.getLastName(),contact.getPhoneNumber(),contact.getEmail(),contact.getMunicipality(),contact.getContactRole(),contact.getCompanyName(),contact.getIndustry(),contact.getContactStreet(),contact.getContactCity(),contact.getContactState(),contact.getContactZip(),contact.getContactID());
    }

    @Override
    public void deleteContact(int contactId) {
        String sql="DELETE FROM contacts WHERE contact_id=?";
        jdbcTemplate.update(sql,contactId);
    }

    @Override
    public Contact getContactByID(int id){
        String sql="SELECT *\n" +
                "FROM contacts\n" +
                "WHERE contact_id = ?;";

        SqlRowSet results=this.jdbcTemplate.queryForRowSet(sql,id);
        Contact contact=null;
         if(results.next()){
            contact = contactObjectMapper(results);
        }
        return contact;
    }
}
