package com.springboot3mongodb.course.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot3mongodb.course.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
