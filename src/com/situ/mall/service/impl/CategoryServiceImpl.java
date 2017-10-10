package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.CategoryDao;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.vo.PageBean;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public PageBean getPageBean(Integer pageIndex, int pageSize) {
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setPageIndex(pageIndex);
		//每一页有多少条数据
		//private Integer pageSize;
		pageBean.setPageSize(pageSize);
		//数据库中一共有多少条记录
		//private Integer totalCount; 
		int totalCount = categoryDao.getTotalCount();
		// TODO 具体实现这个方法而不是写死 
		//int totalCount = 7;
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		//private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize); 
		pageBean.setTotalPage(totalPage);
		// 当前页的数据
		//private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		//SELECT * FROM student WHERE LIMIT 0,3;
		List<Category> list = categoryDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void deletById(int id) {
		categoryDao.deletById(id);
		
	}

	@Override
	public List<Category> findParentCategory() {
		return	categoryDao.findParentCategory();
		 
	}

	@Override
	public List<Category> findCategory(int parentId) {
		return	categoryDao.findCategory(parentId);
	}

	@Override
	public boolean add(Category category) {
		return  categoryDao.add(category);
	}

	@Override
	public Category findById(int id) {
		return categoryDao.findById(id);
	}

	@Override
	public void update(Category category) {
		 categoryDao.update(category);
		
	}
	@Override
	public boolean deleteAll(String[] ids) {
		for (String id : ids) {
			categoryDao.deletById(Integer.parseInt(id));
			
		}
		return true;
	
}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> find(int findCategoryId) {
		return categoryDao.find(findCategoryId);
	}



	
	
}
