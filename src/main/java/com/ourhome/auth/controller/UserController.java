package com.ourhome.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.auth.entity.LoginEntity;
import com.ourhome.auth.entity.User;
import com.ourhome.auth.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name="user_controller", description="User_Controller")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 사용자가 입력한 id로 DB에 해당 사용자가 존재하는지 확인
	 * @param id : 사용자 id
	 * @return : user가 존재하는 경우 OK(200) 코드를, 존재하지 않는다면 NO_CONTENT(204)코드 반환
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginEntity userEntity) {
		System.out.println(userEntity.getId() + " " + userEntity.getPassword());
		User user = userService.selectUser(userEntity.getId(), userEntity.getPassword());
		return new ResponseEntity<>(user, user != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 사용자가 입력한 정보로 회원가입을 진행
	 * @param user : 사용자가 입력한 개인 정보
	 * @return : 회원가입에 성공하는 경우 CREATED(201)코드를, 회원가입에 실패하는 경우 BAD_REQUEST(400)반환
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		System.out.println(user.toString());
		int check = userService.insertUser(user);
		return new ResponseEntity<>(check, check == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/checkID/{userId}")
	public ResponseEntity<?> checkID(@PathVariable String userId) {
		System.out.println(userId);
		int count = userService.checkUserID(userId);
		System.out.println("count : " + count);
		if (count == 0) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();
	}
}
