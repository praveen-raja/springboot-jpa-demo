package com.praveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.praveen.entity.Person;
import com.praveen.repository.PersonRepository;

@SpringBootApplication
@ComponentScan({"com.praveen"})
public class SpringbootJpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		logger.info("All users => {}",repo.findAll());
		logger.info("User id 1 => {}",repo.findById(1));
//		logger.info("All users => {}",repo.findAll());
		logger.info("Insert users => {}",repo.insert(new Person("john", "erode")));
		logger.info("Update user id=3 => {}",repo.update(new Person(3, "john", "coimbatore")));
		repo.deleteById(3);
		logger.info("User id 3 => {}",repo.findById(3));
//		logger.info("All users => {}",repo.findAll());
		
	}
}
