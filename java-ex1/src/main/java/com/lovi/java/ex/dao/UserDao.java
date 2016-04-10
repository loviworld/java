package com.lovi.java.ex.dao;

import java.util.Set;
import com.lovi.java.ex.model.User;

public interface UserDao {
	boolean create(User user);
	boolean update(User user);
	boolean delete(User user);
	User findUserByUserIdAndPassword(User user);
	User findUserByUserId(User user);
	Set<User> listUsers();
	Set<User> findUsersByName(User user);
}
