package com.example.promotionscreatorapp.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.promotionscreatorapp.model.ProductsModel;

public class PromotionsController {

	
	@GetMapping("/promotionadd")
	public String getpromotion(){
		 return "promotionAdd";
		
	}
	
	@PostMapping("/promotionadd")
	public String Addpromotion(){
		 return "promotionAdd";
		
	}
}
