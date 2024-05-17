package com.ourhome.auth.dao;

import org.springframework.stereotype.Repository;

import com.ourhome.auth.entity.User;

@Repository
public interface UserDao {
	/**
	 * front에서 입력한 사용자 정보를 바탕으로 DB에 사용자 정보를 저장
	 * @param user : 회원가입을 희망하는 사용자 객체
	 * @return : 회원가입 성공 시 1, 실패 시 0 반환
	 */
	public int insertUser(User user);
	
	// 로그인을 위한 회원 존재 여부 확인
	// param: 사용자의 id
	// return: 성공 시 1, 실패 시 0
	// 사용자의 id가 db에 존재하는지 확인
	public User selectUser(String id, String password);
	
	/**
	 * @param id: 해당 id를 현재 사용중인 사용자가 있는지 확인
	 * @return : 사용자가 있다면 1을 없다면 0 반환
	 */
	public int getUserID(String userId);
}
