package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.Category;


public interface CategoryDao {

	int getTotalCount();

	List<Category> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	void deletById(int id);

	List<Category> findParentCategory();

	List<Category> findCategory(int parentId);

}
