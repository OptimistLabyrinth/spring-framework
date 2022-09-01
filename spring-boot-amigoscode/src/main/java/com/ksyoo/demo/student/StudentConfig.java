package com.ksyoo.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    2L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY, 25)
            );

            Student draco = new Student(
                    3L,
                    "Draco",
                    "draco.malfoy@gmail.com",
                    LocalDate.of(2002, Month.NOVEMBER, 24)
            );

            studentRepository.saveAll(
                    List.of(mariam, alex, draco)
            );
        };
    }

}
