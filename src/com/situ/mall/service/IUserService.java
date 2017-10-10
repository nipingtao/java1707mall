package com.situ.mall.service;


import com.situ.mall.pojo.User;



public interface IUserService {

	void update(User user);

	boolean add(User user);

	User findByNameAndPassword(String username, String password);



}
