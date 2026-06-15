package com.example.courseRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseRegistration.model.Users;
import com.example.courseRegistration.service.CourseService;
import com.example.courseRegistration.service.UserService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	UserService userService;
	
	
	
	@PostMapping("userRegister")
	public void signUp(@RequestBody Users user) {
		userService.userSignup(user);
		}
	
	
	
}
