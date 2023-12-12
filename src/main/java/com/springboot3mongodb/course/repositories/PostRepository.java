package com.springboot3mongodb.course.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot3mongodb.course.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{'title': {$regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);

	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> advancedSearch(String text, LocalDate minDate, LocalDate maxDate);
}
