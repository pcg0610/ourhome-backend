package com.ourhome.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourhome.auth.dao.UserDao;
import com.ourhome.auth.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User selectUser(String id, String password) {
		return userDao.selectUser(id, password);
	}
	
	@Override
	public int checkUserID(String userId) {
		return userDao.getUserID(userId);
	}
}
