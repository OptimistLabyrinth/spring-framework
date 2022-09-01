package com.ksyoo.spring_master_class_fourth;

import com.ksyoo.spring_master_class_fourth.jpa.PersonJpaRepository;
import com.ksyoo.spring_master_class_fourth.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringMasterClassFourthApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(SpringMasterClassFourthApplication.class);

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassFourthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        usingJpaH2();
    }

    void usingJpaH2() {
        var personList = personJpaRepository.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
        var findId = 10001;
        var personFound = personJpaRepository.findById((long) findId);
        logger.info("Person with ID {} -> {}", findId, personFound);
        var personNew = new Person("Tara", "Berlin", new Date());
        logger.info("Inserted new Person -> {}", personJpaRepository.insert(personNew));
        var updateId = 10003;
        var personUpdate = personJpaRepository.findById((long) updateId);
        personUpdate.setName("Utrecht");
        logger.info("Updated Person with ID {} -> {}", updateId, personJpaRepository.update(personUpdate));
        var deleteId = 10002;
        personJpaRepository.deleteById((long) deleteId);
        logger.info("deleted Person with ID {}", deleteId);
        personList = personJpaRepository.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
    }
}
