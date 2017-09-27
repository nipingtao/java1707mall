package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Product;
import com.situ.mall.vo.PageBean;

public interface IProductService {

	List<Product> findAll();

	void deletById(int id);

	Product findById(int id);

	void update(Product product);

	PageBean getPageBean(int pageIndex, int pageSize);

	boolean add(Product product);

	boolean deleteAll(String[] ids);



}
