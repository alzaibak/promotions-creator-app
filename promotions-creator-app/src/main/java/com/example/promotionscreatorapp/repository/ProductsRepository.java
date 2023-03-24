package com.example.promotionscreatorapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.promotionscreatorapp.model.ProductsModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Integer>{

}
