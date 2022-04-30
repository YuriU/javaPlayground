package com.yuriiu28min.springin5steps;

import com.yuriiu28min.xml.XmlComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsXmlApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXmlApplication.class);

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext applicationContext
					= new ClassPathXmlApplicationContext("applicationContext.xml")) {

			XmlComponentDAO xmlComponentDAO = applicationContext.getBean(XmlComponentDAO.class);

			System.out.println(xmlComponentDAO);
			System.out.println(xmlComponentDAO.getJdbcConnection());
			LOGGER.info("{}", (Object)applicationContext.getBeanDefinitionNames());
			//System.out.println(binarySearch2);

		}
	}

}
