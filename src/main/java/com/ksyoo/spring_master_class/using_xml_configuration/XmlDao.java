package com.ksyoo.spring_master_class.using_xml_configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlDao {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    XmlJdbcConnection xmlJdbcConnection;

    public XmlDao() {
        LOGGER.info("XML DAO OK");
    }

    public XmlDao(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
        LOGGER.info("XML DAO OK (2)");
    }

    public XmlJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }
}
