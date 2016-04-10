package com.lovi.java.ex.dao;

import java.util.HashSet;
import java.util.Set;
import com.lovi.java.ex.data.DataBase;
import com.lovi.java.ex.model.User;

public class UserDaoImpl implements UserDao{
	
	private Set<User> users;
	
	public UserDaoImpl() {
		users = DataBase.create().getSampleUserData();
	}

	@Override
	public boolean create(User user) {
		
		if(users.contains(user))
			return false;
		
		users.add(user);
		
		return true;
	}

	@Override
	public boolean update(User user) {
		if(!users.contains(user))
			return false;
		
		User foundUser = findUserByUserId(user);
		
		users.remove(foundUser);
		
		users.add(user);
		
		return true;
		
	}

	@Override
	public boolean delete(User user) {
		if(!users.contains(user))
			return false;
		
		users.remove(user);
		
		return true;
	}

	@Override
	public User findUserByUserIdAndPassword(User user) {
		for(User u : users){
			if(u.getUserId().equals(user.getUserId()) && u.getPassword().equals(user.getPassword()))
				return u;
		}
		return null;
	}

	@Override
	public User findUserByUserId(User user) {
		for(User u : users){
			if(u.equals(user))
				return u;
		}
		return null;
	}

	@Override
	public Set<User> findUsersByName(User user) {
		Set<User> foundUsers = new HashSet<>();
		for(User u : users){
			if(u.getUserId().equals(user.getName()))
				foundUsers.add(u);
		}
		return foundUsers;
	}

	@Override
	public Set<User> listUsers() {
		return users;
	}

}
