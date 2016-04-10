package com.lovi.java.ex.service;

import java.util.Set;
import com.lovi.java.ex.dao.UserDao;
import com.lovi.java.ex.dao.UserDaoImpl;
import com.lovi.java.ex.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean create(String userId, String password, String name, Integer age){
		return userDao.create(new User(userId, password, name, age));
		
	}

	@Override
	public boolean update(String userId, String password, String name, Integer age){
		return userDao.update(new User(userId, password, name, age));
	}

	@Override
	public boolean delete(String userId){
		return userDao.delete(new User(userId, null, null, null));
	}

	@Override
	public User findUserByUserIdAndPassword(String userId, String password){
		return userDao.findUserByUserIdAndPassword(new User(userId, password, null, null));
	}

	@Override
	public User findUserByUserId(String userId){
		return userDao.findUserByUserId(new User(userId, null, null, null));
	}

	@Override
	public Set<User> findUsersByName(String name) {
		return userDao.findUsersByName(new User(null, name, null, null));
	}

	@Override
	public Set<User> listUsers() {
		return userDao.listUsers();
	}

}
