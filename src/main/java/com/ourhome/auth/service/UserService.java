package com.ourhome.auth.service;

import com.ourhome.auth.entity.User;

public interface UserService {
	// 회원가입
	public int insertUser(User user);
	
	// 로그인을 위한 사용자 조회
	public User selectUser(String id, String password);
	
	// 회원 가입 시 사용가능 여부 판단
	public int checkUserID(String userId);
}
