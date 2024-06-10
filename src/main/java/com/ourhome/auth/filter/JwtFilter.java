package com.ourhome.auth.filter;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1번의 요청에 대하여 filter를 적용할 때 사용
// OPTIONS를 통해 통신 option이 설정되었는지 check하는 역할
// CORS 문제 방지를 위한 역할

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
	}

}
