package com.springboot.restful.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springboot.restful.app.Exceptions.UserNotFoundException;
import com.springboot.restful.app.model.User;
@Service
public class UserService {
	
	private static List<User> users=new ArrayList<>();
	private static Integer userId=2;
	static {
				users.add(new User(1, "madhav", new Date()));
				users.add(new User(2, "Teja", new Date()));
				
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

	public User findById(Integer id) {
		User user = new User();
		for (User usr : users) {
			if (usr.getId() == id) {
				BeanUtils.copyProperties(usr, user);
			}

		}
		if (null == user.getId()) {
			throw new UserNotFoundException("id - " + id);
		}

		return user;

	}
	
	public boolean deleteById(Integer id) {
		Iterator<User> userList=users.iterator();
		boolean flag=false;
		while(userList.hasNext()) {
			User user = userList.next();
			if(id==user.getId()) {
				userList.remove();
				flag=true;
			}
		}
		if (!flag) {
			throw new UserNotFoundException("id - " + id);
		}
		return flag;

	}

}
