package com.ksyoo.spring_master_class_third.jdbc;

import com.ksyoo.spring_master_class_third.entity.Person;
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
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("InnerClassMayBeStatic")
    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    // * SELECT * FROM person
    public List<Person> findAll() {
        // * here originally used "new BeanPropertyRowMapper()" before replacing with custom RowMapper
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    // * SELECT * FROM person WHERE id = ?;
    public Person findById(int id) {
        // * here originally used "new BeanPropertyRowMapper()" before replacing with custom RowMapper
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id = ?", new PersonRowMapper(), id);
    }

    // * DELETE FROM person WHERE id = ?;
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

    // * INSERT INTO person (id, name, location, birth_date) VALUES(?, ?, ?, ?)
    public int insert(Person person) {
        return jdbcTemplate.update(
                "INSERT INTO person (id, name, location, birth_date) " +
                        "VALUES(?, ?, ?, ?)",
                person.getId(),
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime())
        );
    }

    // * UPDATE person WHERE id = ? SET name = ?, location = ?, birth_date = ?
    public int update(Person person) {
        return jdbcTemplate.update(
                "UPDATE person " +
                        "SET name = ?, location = ?, birth_date = ? " +
                        "WHERE id = ?",
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId()
        );
    }
}
