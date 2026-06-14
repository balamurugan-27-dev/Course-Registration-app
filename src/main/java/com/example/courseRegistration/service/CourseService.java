package com.example.courseRegistration.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.courseRegistration.model.Course;
import com.example.courseRegistration.model.CourseRegistry;
import com.example.courseRegistration.repository.CourseRepo;
import com.example.courseRegistration.repository.RegistryRepo;



@Service
public class CourseService {
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	RegistryRepo registryRepo;
	
	public List<Course> listCourse() {
		return courseRepo.findAll();
		
	}
	
	public List<CourseRegistry> entrolled(){

		return registryRepo.findAll();
	}

	public void register(CourseRegistry coureseRegistry) {
		
		registryRepo.save(coureseRegistry);
		
	}
	
	public void deleteCourse(int id ) {
		courseRepo.deleteById(id);
	}

	public void addCourse(Course course) {
		courseRepo.save(course);
		
	}

}
