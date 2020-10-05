package com.api.sportyyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.User;
import com.api.sportyyshoes.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	private MultiValueMap<String, String> errorMap;
	
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		
		return service.createUser(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		
		return service.updateUser(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
		
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}

	
	@GetMapping("/userName/{name}")
	public List<User> getAllUsersByName(@PathVariable String name) {
		
		return service.getAllUsersByName(name);
	}
	
	@GetMapping("/date/{date}")
	public List<User> purchaseReportByDate(@PathVariable String date) {
		
		return service.purchaseReportByDate(date);
	}

	
}
