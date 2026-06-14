package com.example.courseRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseRegistration.model.CourseRegistry;
import com.example.courseRegistration.service.CourseService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/register")
	public String  register(@RequestBody CourseRegistry  courseRegister) {
		courseService.register(courseRegister);
		return "submited successfully";
		
	}
}
