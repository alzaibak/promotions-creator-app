package com.example.promotionscreatorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.promotionscreatorapp.model.ProductsModel;
import com.example.promotionscreatorapp.service.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/")
	public String home(){
		 return "index";
		
	}
	@GetMapping("/allproducts")
	public String getAll(Model model){
		 List<ProductsModel> products =  productsService.getAll();
		 model.addAttribute("products", products);
		 return "allProducts";
		
	}
	
	@RequestMapping(value = "/promotionadd", method= RequestMethod.GET)
	public String addpromotion( ) {
		return "promotionAdd";
		}
	
	@GetMapping("/productAdd")
	public String getAddProductPage(Model model){
		model.addAttribute("productAdding", new ProductsModel());
		 return "productAdd";
		
	}
	
	@PostMapping("/productAdd")
	public String AddProduct(@ModelAttribute ProductsModel ProductsModel){
		ProductsModel addedProduct = productsService.productRegistre(ProductsModel.getLabel(), ProductsModel.getDescription(), ProductsModel.getPrice(), ProductsModel.getCategory(), ProductsModel.getImage());
		return addedProduct == null ? "errorPage": "sucessPage";
		
	}
}
