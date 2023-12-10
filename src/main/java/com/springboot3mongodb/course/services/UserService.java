package com.springboot3mongodb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot3mongodb.course.domain.User;
import com.springboot3mongodb.course.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
