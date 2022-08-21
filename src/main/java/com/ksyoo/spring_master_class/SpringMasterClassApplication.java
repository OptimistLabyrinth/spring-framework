package com.ksyoo.spring_master_class;

import com.ksyoo.spring_master_class.understanding_autowired.BinarySearchImpl;
import com.ksyoo.understanding_component_scan.ComponentDao;
import com.ksyoo.spring_master_class.understanding_scope.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.SystemProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@ComponentScan({
        "com.ksyoo.spring_master_class",
        "com.ksyoo.understanding_component_scan"
})
public class SpringMasterClassApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(SpringMasterClassApplication.class);

    public static void main(String[] args) {
        System.out.println("spring version: " + SpringVersion.getVersion());
        System.out.println("java version:   " + SystemProperties.get("java.version"));
        ApplicationContext applicationContext = SpringApplication.run(SpringMasterClassApplication.class, args);

        understandingAutoWired(applicationContext);
//        understandingScope(applicationContext);
//        understandingComponentScan(applicationContext);
    }

    static void understandingAutoWired(ApplicationContext applicationContext) {
        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
        BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
        LOGGER.info("{}", binarySearch);
        LOGGER.info("{}", binarySearch2);

        var result = binarySearch.binarySearch(new int[]{12, 2, 362, 47, 3, 17}, 7);
        LOGGER.info("{}", result);
    }

    static void understandingScope(ApplicationContext applicationContext) {
        PersonDao personDao = applicationContext.getBean(PersonDao.class);
        PersonDao personDao2 = applicationContext.getBean(PersonDao.class);

        LOGGER.info("{}", personDao);
        LOGGER.info("{}", personDao.getPersonJdbcConnection());
        LOGGER.info("{}", personDao2);
        LOGGER.info("{}", personDao2.getPersonJdbcConnection());
    }

    static void understandingComponentScan(ApplicationContext applicationContext) {
        ComponentDao componentDao = applicationContext.getBean(ComponentDao.class);
        ComponentDao componentDao2 = applicationContext.getBean(ComponentDao.class);

        LOGGER.info("{}", componentDao);
        LOGGER.info("{}", componentDao.getComponentJdbcConnection());
        LOGGER.info("{}", componentDao2);
        LOGGER.info("{}", componentDao2.getComponentJdbcConnection());
    }
}
