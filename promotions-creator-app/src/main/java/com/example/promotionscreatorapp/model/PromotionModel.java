package com.example.promotionscreatorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="promotions")
public class PromotionModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
