package com.situ.mall.service;




import com.situ.mall.pojo.Gg;

import com.situ.mall.vo.PageBean;


public interface IGgService {


	void deletById(int id);

	Gg findById(int id);


	PageBean getPageBean(int pageIndex, int pageSize);

	boolean add(Gg gg);

	boolean deleteAll(String[] ids);



}
