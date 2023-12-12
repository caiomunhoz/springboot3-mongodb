package com.springboot3mongodb.course.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot3mongodb.course.domain.Post;
import com.springboot3mongodb.course.repositories.PostRepository;
import com.springboot3mongodb.course.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text){
		//return repository.findByTitleContainingIgnoreCase(text);
		return repository.searchTitle(text);
	}
	
	public List<Post> advancedSearch(String text, LocalDate minDate, LocalDate maxDate){
		return repository.advancedSearch(text, minDate, maxDate);
	}
	
}
