package com.ksyoo.spring_master_class_third;

import com.ksyoo.spring_master_class_third.entity.Person;
import com.ksyoo.spring_master_class_third.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringMasterClassThirdApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(SpringMasterClassThirdApplication.class);

    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassThirdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        usingJdbcH2();
    }

    void usingJdbcH2() {
        var personList = personJdbcDao.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
        var findId = 10001;
        logger.info("Person with ID {}: {}", findId, personJdbcDao.findById(findId));
        var deleteId = 10002;
        logger.info("Deleted Person with ID {} -> {}", findId, personJdbcDao.deleteById(deleteId));
        var personNew = new Person(10004, "Tara", "Berlin", new Date());
        logger.info("Inserted new Person with ID 10004 -> {}", personJdbcDao.insert(personNew));
        var updateId = 10003;
        var personUpdate = personJdbcDao.findById(updateId);
        personUpdate.setName("Utrecht");
        logger.info("Updated Person with ID {} -> {}", updateId, personJdbcDao.update(personUpdate));
        personList = personJdbcDao.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
    }
}
