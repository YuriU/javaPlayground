package com.yuriiu28min.springin5steps;

import com.yuriiu28min.springin5steps.properties.SomeExternalService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.yuriiu28min.springin5steps.properties")
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext applicationContext
					= new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class)) {

			SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);
			System.out.println(someExternalService.getUrl());
		}
	}

}
