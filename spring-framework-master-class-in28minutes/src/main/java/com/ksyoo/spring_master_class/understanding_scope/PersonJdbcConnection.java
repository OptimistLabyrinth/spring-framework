package com.ksyoo.spring_master_class.understanding_scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonJdbcConnection {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public PersonJdbcConnection() {
        LOGGER.info("Person JDBC Connection OK");
    }
//
//    @PostConstruct
//    public void postConstruct() {
//        LOGGER.info("    postConstruct PersonJdbcConnection Bean");
//    }
//
//    @PreDestroy
//    public void PreDestroy() { LOGGER.info("    PreDestroy PersonJdbcConnection Bean"); }
}
