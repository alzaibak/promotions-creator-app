package com.example.promotionscreatorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.promotionscreatorapp.form.LoginFormClass;

@Controller
public class LoginController {
	
	//to get login page
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public String getLoginForm() {
		//return html page name
		return "login";
	}
	
	//checking for login crediantials
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginFormClass LoginFormClass, Model model) {
		String username = LoginFormClass.getUsername();
		String password = LoginFormClass.getPassword();
		
		if("admin".equals(username) && "admin".equals(password)){
			return "Home";
		}
		model.addAttribute("mot de passe incorrect", true);
		return "login";

	}
}
