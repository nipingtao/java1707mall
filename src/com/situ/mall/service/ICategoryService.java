package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Category;
import com.situ.mall.vo.PageBean;

public interface ICategoryService {

	PageBean getPageBean(Integer pageIndex, int pageSize);

	void deletById(int id);

	List<Category> findParentCategory();

	List<Category> findCategory(int parentId);

}
