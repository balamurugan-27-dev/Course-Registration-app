package com.example.courseRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseRegistration.model.Course;
import com.example.courseRegistration.model.CourseRegistry;
import com.example.courseRegistration.service.CourseService;

@RestController()
@RequestMapping("/user")
public class UserController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("/list")
	public List<Course> listCourse(){
		return courseService.listCourse();
	}
	
	@GetMapping("/enrolled")
	public List<CourseRegistry> enrolled(){
		
		return  courseService.entrolled();
	}
}
