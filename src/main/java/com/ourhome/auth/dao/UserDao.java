package com.ourhome.auth.dao;

import org.springframework.stereotype.Repository;

import com.ourhome.auth.entity.TokenEntity;
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
	public User selectUser(String userId, String password);
	
	/**
	 * @param id: 해당 id를 현재 사용중인 사용자가 있는지 확인
	 * @return : 사용자가 있다면 1을 없다면 0 반환
	 */
	public int getUserID(String userId);
	
	/**
	 * 발급된 token을 테이블에 저장한다.
	 * @param token : 생성된 token 객체
	 * @return : 1 => 토큰 삽입 성공 0 => 실패
	 */
	public int insertToken(TokenEntity token);

	/**
	 * 현재 토큰이 사용 가능한 토큰인지 확인
	 * @param token : 토큰 정보
	 * @return : 1 => 사용 가능(활성화), 0 => 사용 X
	 */
	boolean checkValidToken(String token);

	/**
	 * userId에 해당하는 토큰을 모두 비활성화 처리한다.
	 *	param으로 주어지는 token은 제외
	 * @param userId : 사용자 ID, token: 해시함수를 적용한 Refreshtoken값
	 */
	void setInvalid(String userId, String hashedRefreshToken);
	
	/**
	 * 사용자의 ID로 user 정보를 얻어온다.
	 * @param userId : 사용자 ID
	 * @return : userId를 ID로 갖는 사용자 객체
	 */
	User getUserById(String userId);
	
	void setInvalidById(String userId);
}
