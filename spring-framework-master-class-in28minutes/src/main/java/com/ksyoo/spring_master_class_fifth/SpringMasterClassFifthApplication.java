package com.ksyoo.spring_master_class_fifth;

import com.ksyoo.spring_master_class_fifth.spring_data.PersonSpringDataRepository;
import com.ksyoo.spring_master_class_fifth.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringMasterClassFifthApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringMasterClassFifthApplication.class);

    @Autowired
    PersonSpringDataRepository personSpringDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassFifthApplication.class, args);
    }

    @Override
    public void run(String... args) {
        usingSpringDataH2();
    }

    void usingSpringDataH2() {
        var personList = personSpringDataRepository.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
        var findId = 10001;
        var personFound = personSpringDataRepository.findById((long) findId);
        personFound.ifPresent(person -> logger.info("Person with ID {} -> {}", findId, person));
        var personNew = new Person("Tara", "Berlin", new Date());
        logger.info("Inserted new Person -> {}", personSpringDataRepository.save(personNew));
        var updateId = 10003;
        var personUpdate = personSpringDataRepository.findById((long) updateId);
        personUpdate.ifPresent(person ->
            logger.info("Updated Person with ID {} -> {}", updateId, personSpringDataRepository.save(person))
        );
        var deleteId = 10002;
        var personDelete = personSpringDataRepository.findById((long) deleteId);
        personDelete.ifPresent(person -> {
            personSpringDataRepository.delete(person);
            logger.info("deleted Person with ID {} -> {}", deleteId, personDelete);
        });
        personList = personSpringDataRepository.findAll();
        logger.info("All Users ->");
        for (var person : personList) {
            logger.info("    {}", person);
        }
    }
}
