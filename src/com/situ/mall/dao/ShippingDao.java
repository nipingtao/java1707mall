package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;

public interface ShippingDao {

	List<Shipping> findAll();

	Shipping findByUserId(Integer userId);
	
	List<Product> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	int getTotalCount();

	void deletById(int id);


	boolean add(Shipping shipping);

}
