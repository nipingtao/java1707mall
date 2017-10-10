package com.situ.mall.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.UserDao;

import com.situ.mall.pojo.User;
import com.situ.mall.service.IUserService;



@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}
	@Override
	public boolean add(User user) {
		return  userDao.add(user);
		
	}
	@Override
	public User findByNameAndPassword(String username, String password) {
		return userDao.findByNameAndPassword( username, password);
	}
	
	
	
}
