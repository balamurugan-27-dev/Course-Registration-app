package com.example.courseRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseRegistration.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
  Users findByName(String name);
}
