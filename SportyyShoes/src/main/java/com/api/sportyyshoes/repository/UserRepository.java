package com.api.sportyyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


import com.api.sportyyshoes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByDate(String date);
	
	// @Query("SELECT new com.api.sportyshoes.model.Customer(c.name , c.date , c.) FROM Customer c JOIN c.products p")
    //public List<Customer> purchaseReport();

}
