package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.Product;


public interface ProductDao {

	List<Product> findAll();

	void deletById(int id);

	Product findById(int id);

	void update(Product product);

	int getTotalCount();

	List<Product> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	boolean add(Product product);
}
