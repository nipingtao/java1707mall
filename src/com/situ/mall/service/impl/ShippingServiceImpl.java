package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.ShippingDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShippingService;
import com.situ.mall.vo.PageBean;
@Service
public class ShippingServiceImpl implements IShippingService {
   @Autowired
   private ShippingDao shippingDao;


@Override
public Shipping findByUserId(Integer userId) {
	return shippingDao.findByUserId(userId);
}

@Override
public PageBean getPageBean(Integer pageIndex, int pageSize) {
	PageBean<Product> pageBean = new PageBean<Product>();
	pageBean.setPageIndex(pageIndex);
	//每一页有多少条数据
	//private Integer pageSize;
	pageBean.setPageSize(pageSize);
	//数据库中一共有多少条记录
	//private Integer totalCount; 
	int totalCount = shippingDao.getTotalCount();
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
	List<Product> list = shippingDao.findPageBeanList(index, pageSize);
	pageBean.setList(list);
	
	return pageBean;
}

@Override
public void deletById(int id) {
	shippingDao.deletById(id);
}

@Override
public boolean add(Shipping shipping) {

	return shippingDao.add(shipping);
}

}
