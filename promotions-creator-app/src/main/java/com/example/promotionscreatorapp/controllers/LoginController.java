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
			System.out.println("done");
			model.addAttribute( "userLogin", authenticated.getEmail());
			return "admin";
		}else {
			System.out.println("error");
			return "index";
		}
	}
	
	
	//to get login page
	//@RequestMapping(value= "/login", method=RequestMethod.GET)
	//public String getLoginForm() {
	//	//return html page name
		//return "login";
	//}//
	
	//checking for login crediantials
	//@RequestMapping(value= "/login", method=RequestMethod.POST)
	//public String login(@ModelAttribute(name="loginForm") LoginFormClass LoginFormClass, Model model) {
	//	String username = LoginFormClass.getUsername();
	//	String password = LoginFormClass.getPassword();
		
		//if("admin".equals(username) && "admin".equals(password)){
		//	return "home";
		//}
		//model.addAttribute("mot de passe incorrect", true);
		//return "login";

	//}
}
