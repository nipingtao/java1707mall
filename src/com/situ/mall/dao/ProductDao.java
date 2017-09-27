package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Product;

public interface ProductDao {

	List<Product> findAll();

	void deletById(int id);

	Product findById(int id);

	void update(Product product);

}
