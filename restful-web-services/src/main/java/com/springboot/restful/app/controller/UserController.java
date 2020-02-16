package com.springboot.restful.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restful.app.service.UserService;
import com.springboot.restful.app.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping()
	public List<User> getAllUsers(){
		
		return userService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id){
		
		return userService.findById(id);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public User SaveUser(@RequestBody User user){
		
		return userService.save(user);
		
	}

}
