package com.ksyoo.spring_master_class_third;

import com.ksyoo.spring_master_class.SpringMasterClassApplication;
import com.ksyoo.spring_master_class_third.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMasterClassThirdApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(SpringMasterClassApplication.class);

    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassThirdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var queryResult = personJdbcDao.findAll();
        logger.info("All Users ->");
        for (var each : queryResult) {
            logger.info("    {}", each);
        }
    }
}
