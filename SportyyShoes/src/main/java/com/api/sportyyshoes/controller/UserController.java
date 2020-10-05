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

import java.util.ArrayList;
import java.util.List;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.Shoe;
import com.api.sportyyshoes.model.User;
import com.api.sportyyshoes.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	private MultiValueMap<String, String> errorMap;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
				return new ResponseEntity<>(service.createUser(user), HttpStatus.OK);
		}catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
		

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		return new ResponseEntity<>(service.updateUser(user), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		
	try {
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}catch (BusinessException e) {
		errorMap = new LinkedMultiValueMap<>();
		errorMap.add("errorMessage:", e.getMessage());
		return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
	}
		
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		try {
		service.deleteUserById(id);
		return new ResponseEntity<>("user deleted with id " + id, HttpStatus.OK);
		}catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}

	
	@GetMapping("/userName/{name}")
	public ResponseEntity<List<User>> getAllUsersByName(@PathVariable String name) {
		
		return new ResponseEntity<List<User>>(service.getAllUsersByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/date/{date}")
	public ResponseEntity<List<User>> purchaseReportByDate(@PathVariable String date) {
		
		return new ResponseEntity<List<User>>(service.purchaseReportByDate(date), HttpStatus.OK);
	}
	
	@GetMapping("/reportByCategory/{category}")
	public ResponseEntity<List<User>> purchaseReportByCategory(@PathVariable String category) {
		
		return new ResponseEntity<List<User>>(service.purchaseReportByCategory(category), HttpStatus.OK);
	}

	
}
