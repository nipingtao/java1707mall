package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.vo.PageBean;

public interface ICategoryService {

	PageBean getPageBean(Integer pageIndex, int pageSize);

	void deletById(int id);

	List<Category> findParentCategory();

	List<Category> findCategory(int parentId);

	boolean add(Category category);

	Category findById(int id);

	void update(Category category);

	boolean deleteAll(String[] ids);

	List<Category> findAll();

	List<Category> find(int findCategoryId);


}
