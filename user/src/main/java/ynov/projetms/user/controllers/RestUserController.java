package ynov.projetms.user.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.user.model.User;
import ynov.projetms.user.repositories.UserRepository;

@RestController
public class RestUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/connect")
	public Optional<User> getUser(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<User> user = userRepository.findById(id);		
		System.out.println("Retrieve " + user.get().getName());
		return user;
	}

}
