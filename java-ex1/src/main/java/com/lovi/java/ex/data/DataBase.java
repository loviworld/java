package com.lovi.java.ex.data;
import java.util.HashSet;
import java.util.Set;

import com.lovi.java.ex.model.User;

public class DataBase {

	private static DataBase instance;
	private Set<User> users;
	private DataBase(){
		System.out.println("connect to db...");
		fillSampleUserData();
	}
	
	public synchronized static DataBase create(){
		if(instance == null)instance = new DataBase();
		return instance;
	}
	
	private void fillSampleUserData(){
		users = new HashSet<>();
		users.add(new User("t1", "1234", "t1", 25));
		users.add(new User("t2", "1234", "t2", 25));
		users.add(new User("t3", "1234", "t3", 25));
		users.add(new User("t4", "1234", "t4", 25));
	}
	
	public Set<User> getSampleUserData(){
		return users;
	}
	
	public void setSampleUserData(Set<User> users){
		this.users = users;
	}
}
