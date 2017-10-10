package com.situ.mall.dao;


import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.User;



public interface UserDao {

	void update(User user);

	boolean add(User user);

	User findByNameAndPassword(@Param(value="username")String username, @Param(value="password") String password);

}
