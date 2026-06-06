package com.example.courseRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseRegistration.model.Course;
import com.example.courseRegistration.model.CourseRegistry;
import com.example.courseRegistration.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin("http://localhost:5500")
public class CourseController {
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
	
	@PostMapping("/register")
	public String  register(@RequestBody CourseRegistry  courseRegister) {
		courseService.register(courseRegister);
		return "submited successfully";
		
	}
}
