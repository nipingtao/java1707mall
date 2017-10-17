package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.Product;

public interface OrderBackDao {

	int getTotalCount();

	List<Product> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	void deletById(int id);





}
