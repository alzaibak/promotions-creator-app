package com.example.promotionscreatorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.promotionscreatorapp.model.LoginModel;
import com.example.promotionscreatorapp.model.ProductsModel;
import com.example.promotionscreatorapp.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	ProductsRepository productRepository;
	
	//Get all products
	public List<ProductsModel> getAll(){
		return productRepository.findAll();
		
	}
	
	//Adding product
	public ProductsModel productRegistre(String label, String description ,Integer price,String category, String image) {
		if (label != null && description!=null && price!=null && category!=null && image!=null) {
			ProductsModel ProductsModel = new ProductsModel();
			ProductsModel.setLabel(label);
			ProductsModel.setDescription(description);
			ProductsModel.setPrice(price);
			ProductsModel.setCategory(category);
			ProductsModel.setImage(image);
			return productRepository.save(ProductsModel);
		}else {
			return null;
		}
	}
}
