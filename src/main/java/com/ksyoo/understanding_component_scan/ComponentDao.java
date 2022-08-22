package com.ksyoo.understanding_component_scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Repository
public class ComponentDao {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ComponentJdbcConnection componentJdbcConnection;

    public ComponentDao(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
        LOGGER.info("Component Dao OK");
    }

    public ComponentJdbcConnection getComponentJdbcConnection() {
        return componentJdbcConnection;
    }

    public void setComponentJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
    }
//
//    @PostConstruct
//    public void postConstruct() {
//        LOGGER.info("    postConstruct ComponentDao Bean");
//    }
//
//    @PreDestroy
//    public void PreDestroy() { LOGGER.info("    PreDestroy ComponentDao Bean"); }
}
