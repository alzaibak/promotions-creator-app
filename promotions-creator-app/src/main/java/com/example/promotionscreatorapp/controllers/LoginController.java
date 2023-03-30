package com.example.promotionscreatorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.promotionscreatorapp.model.LoginModel;
import com.example.promotionscreatorapp.service.LoginService;

@Controller
public class LoginController {
	
	public final LoginService loginService;

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
		LoginModel authenticated = loginService.userLogin( loginModel.getUsername(),loginModel.getPassword());
			if(authenticated != null) {
			model.addAttribute( "userLogin", authenticated.getUsername());
			return "allProducts";
		} else {
			return "errorPage";
		}
	}
	
	
}
