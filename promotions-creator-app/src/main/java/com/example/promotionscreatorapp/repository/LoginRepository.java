package com.example.promotionscreatorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.promotionscreatorapp.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Integer>{
	
	Optional<LoginModel> findByUsernameAndPassword(String username, String password);

	
}
