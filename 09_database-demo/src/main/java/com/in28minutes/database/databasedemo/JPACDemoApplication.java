package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JPACDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJPARepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JPACDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User Id 10002 -> {}", repository.findById(10002));
		Person inseted = repository.insert(new Person("Yurii", "Vancouver", new Date(1987, 1, 1)));
		logger.info("Inserted -> {}", inseted);
		logger.info("User Id {} -> {}", inseted.getId(), repository.findById(inseted.getId()));
		inseted.setLocation("Kyiv");
		repository.update(inseted);
		logger.info("User Id {} -> {}", inseted.getId(), repository.findById(inseted.getId()));
		logger.info("All users -> {}", repository.findAll());
		repository.deleteById(inseted.getId());
		logger.info("User Id {} -> {}", inseted.getId(), repository.findById(inseted.getId()));

		logger.info("All users -> {}", repository.findAll());

	}
}
