package com.ourhome.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourhome.auth.dao.UserDao;
import com.ourhome.auth.entity.TokenEntity;
import com.ourhome.auth.entity.User;
import com.ourhome.auth.util.HashUtil;
import com.ourhome.auth.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HashUtil hashUtil;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User selectUser(String id, String password) {
		// 비밀번호 암호화
		String cipherText = hashUtil.getCipherText(password);
		System.out.println("cipherText : " + cipherText);
		// id, password로 사용자 확인
		User user = userDao.selectUser(id, password);
		
		// 해당 사용자가 없는 경우 null
		if (user == null) {
			return null;
		}
		
		// 사용자가 존재하는 경우
		String accessToken = jwtUtil.generateToken(id, "AccessToken");
		String refreshToken = jwtUtil.generateToken(id, "RefreshToken");
		
		return userDao.selectUser(id, password);
	}
	
	@Override
	public int checkUserID(String userId) {
		return userDao.getUserID(userId);
	}
}
