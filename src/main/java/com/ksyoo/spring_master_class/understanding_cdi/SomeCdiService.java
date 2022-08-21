package com.ksyoo.spring_master_class.understanding_cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiService {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Inject
    SomeCdiDao someCdiDao;

    public SomeCdiService(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
        LOGGER.info("Some Contexts and Dependency Injection Service OK");
    }

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }
}
