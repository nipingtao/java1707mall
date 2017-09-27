package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Product;

public interface IProductService {

	List<Product> findAll();

	void deletById(int id);

	Product findById(int id);

	void update(Product product);



}
