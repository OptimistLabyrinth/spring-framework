package com.ksyoo.spring_master_class.understanding_cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
public class SomeCdiDao {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public SomeCdiDao() {
        LOGGER.info("Some Contexts and Dependency Injection DAO OK");
    }
}
