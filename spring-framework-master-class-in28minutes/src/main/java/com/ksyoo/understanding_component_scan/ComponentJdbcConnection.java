package com.ksyoo.understanding_component_scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Component
public class ComponentJdbcConnection {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ComponentJdbcConnection() {
        LOGGER.info("Component JDBC Connection OK");
    }
//
//    @PostConstruct
//    public void postConstruct() {
//        LOGGER.info("    postConstruct ComponentJdbcConnection Bean");
//    }
//
//    @PreDestroy
//    public void PreDestroy() { LOGGER.info("    PreDestroy ComponentJdbcConnection Bean"); }
}
