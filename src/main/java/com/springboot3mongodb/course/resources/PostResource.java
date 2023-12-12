package com.springboot3mongodb.course.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot3mongodb.course.domain.Post;
import com.springboot3mongodb.course.resources.util.URL;
import com.springboot3mongodb.course.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/advancedsearch")
	public ResponseEntity<List<Post>> advancedSearch(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = URL.decodeParam(text);
		LocalDate min = URL.convertDate(minDate);
		LocalDate max = URL.convertDate(maxDate);
		List<Post> list = service.advancedSearch(text, min, max);
		return ResponseEntity.ok().body(list);

	}
}
