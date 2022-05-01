package com.yuriiu28min.springin5steps;

import com.yuriiu28min.xml.XmlComponentDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class BinarySearchXmlImplTest {

    @Autowired
    XmlComponentDAO dao;

    @Test
    public void testBasicScenario() {
        System.out.println(dao.getJdbcConnection());
    }

}