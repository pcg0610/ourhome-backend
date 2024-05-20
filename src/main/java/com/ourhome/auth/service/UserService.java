package com.ourhome.auth.service;

import com.ourhome.auth.entity.AuthEntity;
import com.ourhome.auth.entity.MyPageEntity;
import com.ourhome.auth.entity.TokenEntity;
import com.ourhome.auth.entity.User;

public interface UserService {
	// 회원가입
	public int insertUser(User user);
	
	// 로그인을 위한 사용자 조회
	public AuthEntity selectUser(String userId, String password);
	
	// 회원 가입 시 사용가능 여부 판단
	public int checkUserID(String userId);

	// 토큰이 유효한 토큰인지 확인
	boolean isValidToken(String token);
	
	// 토큰 재생성
	TokenEntity reGenerateToken(String refreshToken);
	
	// 사용자 정보 & item 목록 받아오기
	MyPageEntity myPage(String accessToken);
	
	// 로그아웃
	void logOut(String accessToken);
}
