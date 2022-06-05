package com.techelevator.dao;

import com.techelevator.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGroupDAO implements GroupDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcGroupDAO(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }

    private Group groupObjectMapper(SqlRowSet results){
        Group group=new Group();
        group.setGroupID(results.getInt("group_id"));
        group.setGroupName(results.getString("group_name"));
        group.setProgram_manager_id(results.getInt("program_manager_id"));
        group.setProgram_manager_name(results.getString("program_manager_name"));

        return group;
    }

    @Override
    public List<Group> getAllGroups() {
        String sql="SELECT group_id, group_name, program_manager_id,CONCAT(B.firstname, ' ',lastname) AS program_manager_name " +
                "FROM groups A " +
                "JOIN contacts B ON A.program_manager_id=B.contact_id;";
        SqlRowSet results=this.jdbcTemplate.queryForRowSet(sql);
        List<Group> groups=new ArrayList<>();
        while (results.next()){
            groups.add(groupObjectMapper(results));
        }
        return groups;
    }

    @Override
    public Group getGroupById(int groupId) {
        String sql="SELECT group_id, group_name, program_manager_id,CONCAT(B.firstname, ' ',lastname) AS program_manager_name " +
                "FROM groups A " +
                "JOIN contacts B ON A.program_manager_id=B.contact_id " +
                "WHERE group_id=?;";
        SqlRowSet result=jdbcTemplate.queryForRowSet(sql,groupId);
        if(result.next()){
            return groupObjectMapper(result);
        }else {
            throw new RuntimeException("group "+groupId+" was not found.");
        }
    }

    @Override
    public void addNewGroup(Group group) {
        String sql="INSERT INTO groups (group_name, program_manager_id)" +
                " VALUES(?,?)";
        jdbcTemplate.update(sql,group.getGroupName(),group.getProgram_manager_id());
    }
}
