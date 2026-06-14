package com.example.courseRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseRegistration.model.Course;
import com.example.courseRegistration.service.CourseService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CourseService courseService;
	
	@DeleteMapping("/admin/deletecourse")
	public String deleteCourse(@RequestParam ("id") int id) {
		courseService.deleteCourse(id);
		return"delete successfull";
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return "Course add successfully";
	}
}
