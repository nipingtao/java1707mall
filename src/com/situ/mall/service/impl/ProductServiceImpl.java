package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void deletById(int id) {
		productDao.deletById(id);
		
	}

	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
		
	}
}
