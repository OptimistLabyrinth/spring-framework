package com.ksyoo.spring_master_class.using_xml_configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlJdbcConnection {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public XmlJdbcConnection() {
        LOGGER.info("XML JDBC Connection OK");
    }
}
