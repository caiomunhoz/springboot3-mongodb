package com.springboot3mongodb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot3mongodb.course.domain.User;
import com.springboot3mongodb.course.dto.UserDTO;
import com.springboot3mongodb.course.repositories.UserRepository;
import com.springboot3mongodb.course.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(String id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new ObjectNotFoundException(id);
		}

	}

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(user, newUser);
		return repository.save(newUser);

	}

	public void updateData(User user, User newUser) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
