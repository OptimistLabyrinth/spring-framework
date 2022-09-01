package com.ksyoo.spring_master_class.understanding_scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Repository
public class PersonDao {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcConnection personJdbcConnection;

    public PersonDao(PersonJdbcConnection personJdbcConnection) {
        this.personJdbcConnection = personJdbcConnection;
        LOGGER.info("Person Dao OK");
    }

    public PersonJdbcConnection getPersonJdbcConnection() {
        return personJdbcConnection;
    }

    public void setPersonJdbcConnection(PersonJdbcConnection personJdbcConnection) {
        this.personJdbcConnection = personJdbcConnection;
    }
//
//    @PostConstruct
//    public void postConstruct() {
//        LOGGER.info("    postConstruct PersonDao Bean");
//    }
//
//    @PreDestroy
//    public void PreDestroy() { LOGGER.info("    PreDestroy PersonDao Bean"); }
}
