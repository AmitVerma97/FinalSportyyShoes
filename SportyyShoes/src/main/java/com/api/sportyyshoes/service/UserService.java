package com.api.sportyyshoes.service;

import java.util.List;

import com.api.sportyyshoes.exceptionHandler.BusinessException;
import com.api.sportyyshoes.model.User;

public interface UserService {

	public User createUser(User user);
	public User updateUser(User user);
	public User getUserById(int id) throws BusinessException;
	public void deleteUserById(int id);
	public List<User> getAllUsers();
	public List<User> getAllUsersByName(String name);
	public List<User> purchaseReportByDate(String date);
}
