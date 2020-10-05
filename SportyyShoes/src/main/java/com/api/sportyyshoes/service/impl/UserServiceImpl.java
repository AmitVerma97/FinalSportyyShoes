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
	public User getUserById(int id) {
		
			
			
		return repository.findById(id).get();
	
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
		
		Shoe s1=new Shoe(1,"reebok_1");
		Shoe s2=new Shoe(2,"reebok_2");
		Shoe s3=new Shoe(3,"reebok_3");
		Shoe s4=new Shoe(4,"reebok_4");
		Shoe s5=new Shoe(5,"liberty_1");
		Shoe s6=new Shoe(6,"liberty_2");
		Shoe s7=new Shoe(7,"liberty_3");
		Shoe s8=new Shoe(8,"liberty_4");
		Shoe s9=new Shoe(9,"campus_1");
		Shoe s10=new Shoe(10,"campus_2");
		Shoe s11=new Shoe(11,"campus_3");
		Shoe s12=new Shoe(12,"campus_4");
		Shoe s13=new Shoe(13,"nike_1");
		Shoe s14=new Shoe(14,"nike_2");
		Shoe s15=new Shoe(15,"nike_3");
		Shoe s16=new Shoe(16,"nike_4");
		Shoe s17=new Shoe(17,"nike_5");
		Shoe s18=new Shoe(18,"nike_6");
		Shoe s19=new Shoe(19,"adidas_1");
		Shoe s20=new Shoe(20,"adidas_2");
		Shoe s21=new Shoe(21,"lotto_1");
		Shoe s22=new Shoe(22,"lotto_2");
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
		List<Shoe> l4=new ArrayList<Shoe>();
		List<Shoe> l5=new ArrayList<Shoe>();
		List<Shoe> l6=new ArrayList<Shoe>();
		List<Shoe> l7=new ArrayList<Shoe>();
		List<Shoe> l8=new ArrayList<Shoe>();
		List<Shoe> l9=new ArrayList<Shoe>();
		List<Shoe> l10=new ArrayList<Shoe>();
		List<Shoe> l11=new ArrayList<Shoe>();
		
		l1.add(s11);l1.add(s3);l1.add(s5);l1.add(s2);
		l2.add(s12);l2.add(s3);l2.add(s18);l2.add(s5);
		l3.add(s5);l3.add(s13);l3.add(s7);l3.add(s14);
		l4.add(s22);l4.add(s15);l4.add(s16);
		l5.add(s15);l5.add(s13);l5.add(s17);
		l6.add(s11);l6.add(s20);l6.add(s18);
		l7.add(s14);l7.add(s19);l7.add(s21);
		l8.add(s12);l8.add(s13);l8.add(s18);l8.add(s15);
		l9.add(s15);l9.add(s13);l9.add(s19);l9.add(s14);
		l10.add(s22);l10.add(s15);l10.add(s16);
		l11.add(s15);l11.add(s13);l11.add(s17);
		
		User u1=new User(101,"amit","20sep2020","sneakers",l1);
		User u2=new User(102,"rahul","11sep2020","trekking",l2);
		User u3=new User(103,"deepak","13jun2020","formal",l3);
		User u4=new User(104,"kamya","30sep2020","formal",l4);
		User u5=new User(105,"ujjwal","03mar2020","formal",l5);
		User u6=new User(106,"sakshi","30sep2020","sneakers",l6);
		User u7=new User(107,"sumit","11sep2020","trekking",l7);
		User u8=new User(108,"amit","03sep2020","formal",l8);
		User u9=new User(109,"ujjwal","22oct2020","formal",l9);
		User u10=new User(110,"amit","13jun2020","trekking",l10);
		User u11=new User(111,"sumit","22oct2020","trekking",l11);
		
		repository.save(u1);
		repository.save(u2);
		repository.save(u3);
		repository.save(u4);
		repository.save(u5);
		repository.save(u6);
		repository.save(u7);
		repository.save(u8);
		repository.save(u9);
		repository.save(u10);
		repository.save(u11);
	
		
			
		}

	@Override
	public List<User> purchaseReportByCategory(String category) {
		
		return repository.findByCategory(category);
	}




	

	

}