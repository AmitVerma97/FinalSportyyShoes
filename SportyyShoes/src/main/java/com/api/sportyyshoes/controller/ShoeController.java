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
import com.api.sportyyshoes.model.Shoe;

import com.api.sportyyshoes.service.ShoeService;

@RestController
public class ShoeController {

	@Autowired
	private ShoeService service;
	//private Orders buy;
	
	private MultiValueMap<String, String> errorMap;
	
	
	
	@PostMapping("/shoe")
	public Shoe createShoe(@RequestBody Shoe shoe) {
		
		return service.createShoe(shoe);
	}

	@PutMapping("/shoe")
	public Shoe updateShoe(@RequestBody Shoe shoe) {
		
		return service.updateShoe(shoe);
	}

	@GetMapping("/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getShoeById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteShoe/{id}")
	public void deleteShoeById(@PathVariable int id) {
		service.deleteShoeById(id);
		
	}
	
	@GetMapping("/allShoes")
	public List<Shoe> getAllShoes() {
		
		return service.getAllShoes();
	}

	
	@GetMapping("/shoeName/{name}")
	public List<Shoe> getAllShoesByName(@PathVariable String name) {
		
		return service.getAllShoesByShoeName(name);
	}
	
	@GetMapping("/shoeCategory/{name}")
	public List<Shoe> getAllShoesByCategory(@PathVariable String name) {
		
		return service.getAllShoesByCategory(name);
	}

	
}
