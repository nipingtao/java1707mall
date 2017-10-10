package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.situ.mall.pojo.Gg;



public interface GgDao {
	

	void deletById(int id);

	Gg findById(int id);

	

	int getTotalCount();

	List<Gg> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	boolean add(Gg gg);


}
