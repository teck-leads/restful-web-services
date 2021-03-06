package com.springboot.restful.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.springboot.restful.app.Exceptions.UserNotFoundException;
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
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {

		User user = userService.findById(Integer.valueOf(id));

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable("id") String id) {

		userService.deleteById(Integer.valueOf(id));
		UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id);
		// return new ResponseEntity<Object>(HttpStatus.OK);

		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri.toUri());
		return new ResponseEntity<Object>(headers, HttpStatus.OK);

	}

	 @RequestMapping(method = RequestMethod.POST) 
	/* @PostMapping */
	public ResponseEntity<Object> save(@RequestBody User user) {
		 user= userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user); 
		/* return ResponseEntity.created(uri).build(); */

	}

}
