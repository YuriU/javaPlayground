package com.yuriiu28min.xml;

public class XmlComponentDAO {

     XmlComponentJdbcConnection componentJdbcConnection;

    public XmlComponentJdbcConnection getJdbcConnection() {
        return componentJdbcConnection;
    }

    public void setComponentJdbcConnection(XmlComponentJdbcConnection jdbcConnection) {
        this.componentJdbcConnection = jdbcConnection;
    }
}
