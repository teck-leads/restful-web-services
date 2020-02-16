package com.springboot.restful.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restful.app.model.Hello;

@RestController
@RequestMapping(value = "/users")
public class HelloWorldController {
	
	@GetMapping(value = "/hello")
	public String getHello() {
		return "hello World is very difficult program to write in this world";
		
	}
	@GetMapping(value = "/hlo/{name}")
	public Hello getHelloModel(@PathVariable("name") String name) {
		Hello hello =new Hello(  String.format("Hello World, %s",name) );
		return hello;
		
	}

}
