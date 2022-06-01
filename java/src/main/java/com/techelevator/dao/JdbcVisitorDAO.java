package com.techelevator.dao;

import com.techelevator.model.Visitor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVisitorDAO implements VisitorDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcVisitorDAO(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private Visitor visitorObjectMapper(SqlRowSet results){
        Visitor visitors = new Visitor();
        visitors.setVisitorID(results.getInt("visitor_id"));
        visitors.setFirstName(results.getString("firstName"));
        visitors.setLastName(results.getString("lastName"));
        visitors.setCompany_position(results.getString("company_position"));

        return visitors;
    }



    @Override
    public List<Visitor> listAllVisitors() {

        String sql = "SELECT * FROM visitors";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Visitor> visitors = new ArrayList<>();

        while (results.next()){
            visitors.add(visitorObjectMapper(results));
        }

        return visitors;
    }


}
