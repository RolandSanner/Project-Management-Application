package com.techelevator.dao;

import com.techelevator.model.GroupContact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcGroupContactDAO implements GroupContactDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcGroupContactDAO(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }

    @Override
    public void addConnection(GroupContact groupContact) {
        String sql="INSERT INTO group_contacts (contact_id,group_id) " +
                "VALUES (?,?);";
        jdbcTemplate.update(sql,groupContact.getContact_id(),groupContact.getGroup_id());
    }

    @Override
    public void changeConnection(GroupContact groupContact) {
        String sql="UPDATE group_contacts SET group_id=? WHERE contact_id=?;";
        jdbcTemplate.update(sql,groupContact.getGroup_id(),groupContact.getContact_id());
    }

    @Override
    public void deleteConnection(int groupId, int contactId) {
        String sql="DELETE FROM group_contacts WHERE group_id=? AND contact_id=?";
        jdbcTemplate.update(sql,groupId,contactId);
    }

    private GroupContact groupContactObjectMapper(SqlRowSet results){
        GroupContact groupContact=new GroupContact();
        groupContact.setGroup_id(results.getInt("group_id"));
        groupContact.setContact_id(results.getInt("contact_id"));
        return groupContact;
    }
}
