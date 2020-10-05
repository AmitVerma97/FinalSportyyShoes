package com.api.sportyyshoes.service.impl;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.Shoe;
import com.api.sportyyshoes.model.User;
import com.api.sportyyshoes.repository.ShoeRepository;
import com.api.sportyyshoes.repository.UserRepository;
import com.api.sportyyshoes.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user) {
		
		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserById(int id) throws BusinessException {
		User user=null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be zero or negative");
			}
		user=repository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No User found with id = "+id);
		}
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return repository.findAll();
	}

	

	@Override
	public List<User> getAllUsersByName(String name) {
		
		return repository.findByName(name);
	}

	@Override
	public List<User> purchaseReportByDate(String date) {
		
		return repository.findByDate(date);
	}

	@PostConstruct
	public void placeOrders(){
		
		Shoe s1=new Shoe(1,"reebok1","running");
		Shoe s2=new Shoe(2,"reebok","formal");
		Shoe s3=new Shoe(3,"reebok","sneakers");
		Shoe s4=new Shoe(4,"reebok","hiking");
		Shoe s5=new Shoe(5,"liberty","running");
		Shoe s6=new Shoe(6,"liberty","formal");
		Shoe s7=new Shoe(7,"liberty","sneakers");
		Shoe s8=new Shoe(8,"liberty","hiking");
		/*repo.save(s1);
		repo.save(s2);
		repo.save(s3);
		repo.save(s4);
		repo.save(s5);
		repo.save(s6);
		repo.save(s7);
		repo.save(s8);*/
		
		List<Shoe> l1=new ArrayList<Shoe>();
		List<Shoe> l2=new ArrayList<Shoe>();
		List<Shoe> l3=new ArrayList<Shoe>();
		l1.add(s1);l1.add(s3);l1.add(s5);l1.add(s2);
		l2.add(s2);l2.add(s3);l2.add(s8);l2.add(s5);
		l3.add(s5);l3.add(s3);l3.add(s5);l3.add(s6);
		User u1=new User(101,"amit","20sep2020",l1);
		User u2=new User(102,"aman","20sep2020",l2);
		User u3=new User(103,"amrit","30sep2020",l3);
		
		repository.save(u1);
		repository.save(u2);
		repository.save(u3);
		
			
		}




	

	

}