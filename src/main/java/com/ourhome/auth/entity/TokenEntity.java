package com.ourhome.auth.entity;

/**
 * 각 사용자의 Token 정보를 관리하기 위한 Entity
 */

/**
 * userId를 기반으로 token을 생성한다.
 */
public class TokenEntity {
	private String userId;
	private String token;
	private long issuedAt;
	private long expiration;
	
	public TokenEntity(String userId, String token, long issuedAt, long expiration) {
		this.userId = userId;
		this.token = token;
		this.issuedAt = issuedAt;
		this.expiration = expiration;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public long getIssuedAt() {
		return issuedAt;
	}
	public void setIssuedAt(long issuedAt) {
		this.issuedAt = issuedAt;
	}
	
	public long getExpiration() {
		return expiration;
	}
	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}
	
	@Override
	public String toString() {
		return "Token [userId=" + userId + ", token=" + token + ", issuedAt=" + issuedAt + ", expiration=" + expiration
				+ "]";
	}
}
