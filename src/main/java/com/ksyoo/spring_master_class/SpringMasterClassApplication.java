package com.ksyoo.spring_master_class;

import com.ksyoo.spring_master_class.understanding_autowired.BinarySearchImpl;
import com.ksyoo.spring_master_class.understanding_cdi.SomeCdiService;
import com.ksyoo.spring_master_class.using_external_properties.ExternalService;
import com.ksyoo.spring_master_class.using_xml_configuration.XmlDao;
import com.ksyoo.understanding_component_scan.ComponentDao;
import com.ksyoo.spring_master_class.understanding_scope.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SpringVersion;

@Configuration
@ComponentScan({
        "com.ksyoo.spring_master_class",
        "com.ksyoo.understanding_component_scan"
})
@PropertySource("classpath:app.properties")
public class SpringMasterClassApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(SpringMasterClassApplication.class);

    public static void main(String[] args) {
        System.out.println("spring version: " + SpringVersion.getVersion());
        System.out.println("java version:   " + Runtime.version());
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext
                     = new AnnotationConfigApplicationContext(SpringMasterClassApplication.class)) {
            LOGGER.info("Beans Loaded (AnnotationConfigApplicationContext) -> {}",
                    (Object) annotationConfigApplicationContext.getBeanDefinitionNames());
//            understandingAutoWired(annotationConfigApplicationContext);
//            understandingScope(annotationConfigApplicationContext);
//            understandingComponentScan(annotationConfigApplicationContext);
//            understandingContextsAndDependencyInjection(annotationConfigApplicationContext);
//            understandingPropertiesFromExternalFile(annotationConfigApplicationContext);
            understandingJunitAndMockito(annotationConfigApplicationContext);
        }
        try (ClassPathXmlApplicationContext classPathXmlApplicationContext
                     = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            LOGGER.info("Beans Loaded (ClassPathXmlApplicationContext) -> {}",
                    (Object) classPathXmlApplicationContext.getBeanDefinitionNames());
//            understandingXmlConfiguration(classPathXmlApplicationContext);
        }
    }

    static void understandingAutoWired(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        BinarySearchImpl binarySearch = annotationConfigApplicationContext.getBean(BinarySearchImpl.class);
        BinarySearchImpl binarySearch2 = annotationConfigApplicationContext.getBean(BinarySearchImpl.class);
        LOGGER.info("{}", binarySearch);
        LOGGER.info("{}", binarySearch2);

        var result = binarySearch.binarySearch(new int[]{12, 2, 362, 47, 3, 17}, 7);
        LOGGER.info("{}", result);
    }

    static void understandingScope(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        PersonDao personDao = annotationConfigApplicationContext.getBean(PersonDao.class);
        PersonDao personDao2 = annotationConfigApplicationContext.getBean(PersonDao.class);

        LOGGER.info("{}", personDao);
        LOGGER.info("{}", personDao.getPersonJdbcConnection());
        LOGGER.info("{}", personDao2);
        LOGGER.info("{}", personDao2.getPersonJdbcConnection());
    }

    static void understandingComponentScan(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ComponentDao componentDao = annotationConfigApplicationContext.getBean(ComponentDao.class);
        ComponentDao componentDao2 = annotationConfigApplicationContext.getBean(ComponentDao.class);

        LOGGER.info("{}", componentDao);
        LOGGER.info("{}", componentDao.getComponentJdbcConnection());
        LOGGER.info("{}", componentDao2);
        LOGGER.info("{}", componentDao2.getComponentJdbcConnection());
    }

    static void understandingContextsAndDependencyInjection(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        SomeCdiService someCdiService = annotationConfigApplicationContext.getBean((SomeCdiService.class));

        LOGGER.info("{}", someCdiService);
        LOGGER.info("{}", someCdiService.getSomeCdiDao());
    }

    static void understandingXmlConfiguration(ClassPathXmlApplicationContext classPathXmlApplicationContext) {
        XmlDao xmlDao = classPathXmlApplicationContext.getBean(XmlDao.class);

        LOGGER.info("{}", xmlDao);
        LOGGER.info("{}", xmlDao.getXmlJdbcConnection());
    }

    static void understandingPropertiesFromExternalFile(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ExternalService externalService = annotationConfigApplicationContext.getBean(ExternalService.class);

        LOGGER.info("{}", externalService);
        LOGGER.info("{}", externalService.getServiceUrl());
    }

    static void understandingJunitAndMockito(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
    }
}
