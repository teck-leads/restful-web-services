package com.springboot.restful.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restful.app.model.User;
@Service
public class UserService {
	
	private static List<User> users=new ArrayList<>();
	private static Integer userId=2;
	static {
				users.add(new User(1, "user-1", new Date()));
				users.add(new User(2, "user-2", new Date()));
				
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(null==user.getId()) {
			user.setId(++userId);
		}
		users.add(user);
		return findById(user.getId());
	}
	public User findById(Integer id){
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
			
		}
		return null;
	}

}
