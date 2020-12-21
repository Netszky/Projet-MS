package ynov.projetms.user.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.user.model.User;
import ynov.projetms.user.repositories.UserRepository;

@RestController
public class RestUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/allUser")
	public Iterable<User> getUsers() {		
		Iterable<User> users = userRepository.findAll();
		return users;		
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	@PostMapping("/sign_in")
	public User createUser(@RequestBody User user) {
		user = userRepository.save(user);		
		return user;
	}
	
	@DeleteMapping("/profil/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/profil/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		User currentUser = userRepository.findById(id).get();	
		
		String username = user.getName();
		if(username != null) {
			currentUser.setName(username);
		}
		
		String mail = user.getMail();
		if(mail != null) {
			currentUser.setMail(mail);
		}
		
		String password = user.getPassword();
		if(password != null) {
			currentUser.setPassword(password);
		}
		
		currentUser = userRepository.save(currentUser);
		return currentUser;
	}

}
