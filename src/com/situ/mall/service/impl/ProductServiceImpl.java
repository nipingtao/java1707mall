package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;




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

	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(pageIndex);
		//每一页有多少条数据
		//private Integer pageSize;
		pageBean.setPageSize(pageSize);
		//数据库中一共有多少条记录
		//private Integer totalCount; 
		int totalCount = productDao.getTotalCount();
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
		List<Product> list = productDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public boolean add(Product product) {
		return  productDao.add(product);
		
	}
		@Override
		public boolean deleteAll(String[] ids) {
			for (String id : ids) {
				productDao.deletById(Integer.parseInt(id));
				
			}
			return true;
		
	}

		@Override
		public PageBean<Product> searchByCondition(SearchCondition searchCondition) {
			PageBean<Product> pageBean = new PageBean<Product>();
			 //当前是第几页
			pageBean.setPageIndex(searchCondition.getPageIndex());
			System.out.println(searchCondition.getPageIndex());
			//每一页有多少条数据
			pageBean.setPageSize(searchCondition.getPageSize());
			//数据库中一共有多少条记录
			int totalCount = productDao.getTotalCount1(searchCondition);
			pageBean.setTotalCount(totalCount);
			// 一共有多少页
			int totalPage = (int) Math.ceil(1.0 * totalCount / searchCondition.getPageSize()); 
			pageBean.setTotalPage(totalPage);
			// 当前页的数据
			searchCondition.setPageIndex((searchCondition.getPageIndex() - 1) * searchCondition.getPageSize());
			List<Product> list = productDao.findPageBeanList1(searchCondition);
			pageBean.setList(list);
			return pageBean;
		}

		@Override
		public List<Category> findParentCategory() {
			return  productDao.findParentCategory();
		}

		@Override
		public List<Product> find(int CategoryId) {
			return productDao.find(CategoryId);
		}

		
		}

	

