package com.ufcg.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.workshopmongo.domain.User;
import com.ufcg.workshopmongo.dto.UserDTO;
import com.ufcg.workshopmongo.repository.UserRepository;
import com.ufcg.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll(); 
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		User newUser = this.findById(user.getId());
		this.updateData(newUser, user);
		return this.userRepository.save(newUser);
	}
	
	public void updateData(User newUser, User user) {
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
	}
	
	public void deleteUser(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
