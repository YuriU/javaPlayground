package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonalRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();

            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthdate(rs.getTimestamp("birth_date"));

            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(
                "select * from person",
                new PersonalRowMapper()
                //new BeanPropertyRowMapper<Person>(Person.class)
                );
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from person where id=?",
                new Object[] { id }, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )\n" +
                        "VALUES(?, ?, ?, ?);",
                new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime()) });
    }

    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from person where id=?",
                new Object[] { id });
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "UPDATE PERSON SET NAME = ?, LOCATION =?, BIRTH_DATE = ? WHERE ID = ?",
                new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime()), person.getId() });
    }
}
