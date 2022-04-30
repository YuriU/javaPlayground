package com.yuriiu28min.xml;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class XmlComponentJdbcConnection {
    public XmlComponentJdbcConnection() {
        System.out.println("JDBC Connection");
    }
}
