package com.api.sportyyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sportyyshoes.model.Shoe;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
	
	public List<Shoe> findByShoeName(String name);
	//public List<Shoe> findByCategory(String name);

}
