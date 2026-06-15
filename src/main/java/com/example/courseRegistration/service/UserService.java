package com.example.courseRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.example.courseRegistration.model.UserPrinciple;
import com.example.courseRegistration.model.Users;
import com.example.courseRegistration.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;
	
	BCryptPasswordEncoder encoder=  new BCryptPasswordEncoder(12);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepo.findByName(username);
		return new  UserPrinciple(user);
	}
	
	public void userSignup(Users user) {
		
		user.setRole("USER");
		String enpass=encoder.encode(user.getPassword());
		user.setPassword(enpass);
		userRepo.save(user);
		
	}
}
