package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User Id 10002 -> {}", dao.findById(10002));
		logger.info("Delete Id 10002 -> {}", dao.deleteById(10002));
		logger.info("All users -> {}", dao.findAll());
		logger.info("Inserted 10004 -> {}", dao.insert(new Person(10004, "Jason", "Statham", new Date(1980, 1, 1))));
		logger.info("All users -> {}", dao.findAll());
		logger.info("Inserted 10004 -> {}", dao.update(new Person(10004, "Will", "Smith", new Date(1981, 1, 1))));
		logger.info("All users -> {}", dao.findAll());
	}
}
