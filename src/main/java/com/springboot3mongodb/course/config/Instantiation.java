package com.springboot3mongodb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot3mongodb.course.domain.User;
import com.springboot3mongodb.course.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		
		User u1 = new User(null, "Ryan Gosling", "ryang@gmail.com");
		User u2 = new User(null, "Ana de Armas", "ana@outlook.com");
		User u3 = new User(null, "Harrison Ford", "hford@hotmail.com");
		
		userRepo.saveAll(Arrays.asList(u1, u2, u3));
	}

}
