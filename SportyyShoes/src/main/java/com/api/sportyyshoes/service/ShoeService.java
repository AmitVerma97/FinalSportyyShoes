package com.api.sportyyshoes.service;

import java.util.List;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.Shoe;

public interface ShoeService {

	public Shoe createShoe(Shoe shoe);
	public Shoe updateShoe(Shoe shoe);
	public Shoe getShoeById(int id) throws BusinessException;
	public void deleteShoeById(int id);
	public List<Shoe> getAllShoes();
	public List<Shoe> getAllShoesByShoeName(String name);
	//public List<Shoe> getAllShoesByCategory(String name);
}
