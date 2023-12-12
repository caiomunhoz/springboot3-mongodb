package com.springboot3mongodb.course.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot3mongodb.course.domain.Post;
import com.springboot3mongodb.course.domain.User;
import com.springboot3mongodb.course.dto.AuthorDTO;
import com.springboot3mongodb.course.repositories.PostRepository;
import com.springboot3mongodb.course.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User u1 = new User(null, "Ryan Gosling", "ryang@gmail.com");
		User u2 = new User(null, "Ana de Armas", "ana@outlook.com");
		User u3 = new User(null, "Harrison Ford", "hford@hotmail.com");
		
		userRepo.saveAll(Arrays.asList(u1, u2, u3));
		
		Post p1 = new Post(null, "Went on a trip", "Going to Sao Paulo!", LocalDate.parse("11/12/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new AuthorDTO(u1));
		Post p2 = new Post(null, "Good morning", "Woke up happy today!", LocalDate.parse("12/12/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new AuthorDTO(u1));
		
		postRepo.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepo.save(u1);
	}

}
