package com.yuriiu28min.springin5steps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yuriiu28min.springin5steps")
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext applicationContext
					= new AnnotationConfigApplicationContext(SpringIn5StepsApplication.class)) {

			SomeCDIBusiness cdiBusiness = applicationContext.getBean(SomeCDIBusiness.class);
			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
			//BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
			int result = binarySearch.binarySearch(new int[] { 12, 3, 4 }, 3);

			System.out.println(binarySearch);
			//System.out.println(binarySearch2);
			System.out.println(result);
		}
	}

}
