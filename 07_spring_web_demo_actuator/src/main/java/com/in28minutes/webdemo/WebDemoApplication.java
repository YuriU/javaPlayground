package com.in28minutes.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WebDemoApplication.class, args);
		for (String name: context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
