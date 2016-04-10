package com.lovi.java.ex.service;

import java.util.Set;
import com.lovi.java.ex.model.User;

public interface UserService {

	boolean create(String userId, String password, String name, Integer age);
	boolean update(String userId, String password, String name, Integer age);
	boolean delete(String userId);
	User findUserByUserIdAndPassword(String userId, String password);
	User findUserByUserId(String userId);
	Set<User> listUsers();
	Set<User> findUsersByName(String name);
}
