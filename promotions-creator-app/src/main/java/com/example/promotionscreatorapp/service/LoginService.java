package com.example.promotionscreatorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.promotionscreatorapp.repository.LoginRepository;
import com.example.promotionscreatorapp.model.LoginModel;

@Service
public class LoginService {
	
	private final LoginRepository loginRepository;

	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public LoginModel userRegistre(String email, String password) {
		if (email != null && password!=null) {
			LoginModel LoginModel = new LoginModel();
			LoginModel.setEmail(email);
			LoginModel.setPassword(password);
			return loginRepository.save(LoginModel);
		}
		return null;
	}
	
	public LoginModel userLogin(String email, String password) {
		return loginRepository.findByEmailAndPassword(email,password).orElse(null);
	}

	

}
