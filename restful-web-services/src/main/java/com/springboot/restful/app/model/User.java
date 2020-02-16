package com.springboot.restful.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class User {
	private Integer id;
	
	private String name;
	private Date birthDate;

}
