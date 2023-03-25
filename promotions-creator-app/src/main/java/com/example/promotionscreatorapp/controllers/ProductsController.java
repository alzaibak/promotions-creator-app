package com.example.promotionscreatorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.promotionscreatorapp.model.ProductsModel;
import com.example.promotionscreatorapp.service.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/products")
	public String getAll(Model model){
		 List<ProductsModel> products =  productsService.getAll();
		 model.addAttribute("products", products);
		 return "allproducts";
		
	}

}
