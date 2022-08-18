package com.ksyoo.spring_master_class;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMasterClassApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringMasterClassApplication.class, args);
        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
        var result = binarySearch.binarySearch(new int[]{12, 2, 362, 47, 3, 17}, 7);
        System.out.println(result);
    }
}
