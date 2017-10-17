package com.situ.mall.service;


import com.situ.mall.pojo.Order;
import com.situ.mall.vo.PageBean;

public interface IOrderServiceBack {

	PageBean getPageBean(Integer pageIndex, int pageSize);

	void deletById(int id);




	

}
