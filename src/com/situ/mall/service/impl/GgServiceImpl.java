package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.GgDao;
import com.situ.mall.pojo.Gg;
import com.situ.mall.service.IGgService;
import com.situ.mall.vo.PageBean;
@Service
public class GgServiceImpl implements IGgService {
	@Autowired
	private GgDao ggDao;

	@Override
	public void deletById(int id) {
		ggDao.deletById(id);
		
	}

	@Override
	public Gg findById(int id) {
		return ggDao.findById(id);
	}


	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean<Gg> pageBean = new PageBean<Gg>();
		pageBean.setPageIndex(pageIndex);
		//每一页有多少条数据
		//private Integer pageSize;
		pageBean.setPageSize(pageSize);
		//数据库中一共有多少条记录
		//private Integer totalCount; 
		int totalCount = ggDao.getTotalCount();
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
		List<Gg> list = ggDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public boolean add(Gg gg) {
		return  ggDao.add(gg);
		
	}
		@Override
		public boolean deleteAll(String[] ids) {
			for (String id : ids) {
				ggDao.deletById(Integer.parseInt(id));
				
			}
			return true;
		
	}


}
