package com.ksyoo.spring_master_class_second;

import com.ksyoo.spring_master_class_second.aop.business1.Service1;
import com.ksyoo.spring_master_class_second.aop.business2.Service2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMasterClassSecondApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Service1 service1;

    @Autowired
    private Service2 service2;

    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassSecondApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var a = service1.calculateSomething();
        logger.info("a: " + a);
        var b = service2.calculateSomething();
        logger.info("b: " + b);
    }
}
