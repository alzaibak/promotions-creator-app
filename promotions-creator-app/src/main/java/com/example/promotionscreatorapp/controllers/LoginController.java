package com.example.promotionscreatorapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.promotionscreatorapp.model.LoginModel;
import com.example.promotionscreatorapp.service.LoginService;

@Controller
public class LoginController {
	
	public final LoginService loginService;
	
	
	//@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	
	@RequestMapping(value = "/login", method= RequestMethod.GET)
		public String getLoginPage(Model model) {
		model.addAttribute( "loginRequest", new LoginModel());
		return "login";
		}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public String login(@ModelAttribute LoginModel loginModel, Model model) {
		System.out.println("login:" + loginModel);
		LoginModel authenticated = loginService.userLogin( loginModel.getEmail(), loginModel.getPassword());
		if (authenticated != null) {
			model.addAttribute( "userLogin", authenticated.getEmail());
			return "admin";
		}else {
			return "errorPage";
		}
	}
	
}
