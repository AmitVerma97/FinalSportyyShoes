package com.api.sportyyshoes.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.Shoe;
import com.api.sportyyshoes.repository.ShoeRepository;
import com.api.sportyyshoes.service.ShoeService;

@Service
public class ShoeServiceImpl implements ShoeService{

	@Autowired
	private ShoeRepository repository;
	
	@Override
	public Shoe createShoe(Shoe shoe) {
		
		return repository.save(shoe);
	}

	@Override
	public Shoe updateShoe(Shoe shoe) {
		return repository.save(shoe);
	}

	@Override
	public Shoe getShoeById(int id) throws BusinessException {
		Shoe shoe=null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be zero or negative");
			}
		shoe=repository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Shoe found with id = "+id);
		}
		return shoe;
	}

	@Override
	public void deleteShoeById(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Shoe> getAllShoes() {
		
		return repository.findAll();
	}

	
	@Override
	public List<Shoe> getAllShoesByShoeName(String name) {
		// TODO Auto-generated method stub
		return repository.findByShoeName(name);
	}

	@Override
	public List<Shoe> getAllShoesByCategory(String name) {
		// TODO Auto-generated method stub
		return repository.findByCategory(name);
	}



	

	

}