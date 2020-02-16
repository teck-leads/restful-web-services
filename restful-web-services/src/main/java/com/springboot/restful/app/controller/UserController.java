package com.springboot.restful.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.springboot.restful.app.service.UserService;
import com.springboot.restful.app.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping()
	public List<User> getAllUsers() {

		return userService.findAll();

	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {

		return userService.findById(id);

	}

	 @RequestMapping(method = RequestMethod.POST) 
	/* @PostMapping */
	public ResponseEntity<Object> SaveUser(@RequestBody User user) {
		 user= userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user); 
		/* return ResponseEntity.created(uri).build(); */

	}

}
