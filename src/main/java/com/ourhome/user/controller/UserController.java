package com.ourhome.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.user.service.UserService;

import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

/**
 * UserController
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 사용자를 조회하는 요청을 처리하는 메서드
     * 
     * @param id 조회할 대상의 고유번호
     * @return 처리 결과
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") Long id) {

        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(user);
    }

    /**
     * 사용자를 등록하는 요청을 처리하는 메서드
     * 
     * @param createRequestUserDto 등록할 사용자의 정보
     * @return 처리 결과
     */
    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody UserCreateRequestDto createRequestUserDto) {

        int result = userService.signUp(createRequestUserDto);

        if (result == 0) {
            return ResponseEntity.badRequest().body("회원가입 실패");
        }

        return ResponseEntity.ok("회원가입 성공");
    }

    /**
     * 사용자를 삭제하는 요청을 처리하는 메서드
     * 
     * @param id 삭제할 사용자의 고유번호
     * @return 처리 결과
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) {

        int result = userService.deleteUserById(id);

        if (result == 0) {
            return ResponseEntity.badRequest().body("회원 삭제 실패");
        }

        return ResponseEntity.ok("회원 삭제 성공");
    }

    /**
     * 사용자의 정보를 수정하는 요청을 처리하는 메서드
     * 
     * @param id 수정할 사용자의 고유번호
     * @param updateUserDto 수정할 데이터
     * @return 처리 결과
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Long id,
            @RequestBody UserUpdateRequestDto updateUserDto) {

        int result = userService.updateUserById(id, updateUserDto);

        if (result == 0) {
            return ResponseEntity.badRequest().body("회원 정보 수정 실패");
        }

        return ResponseEntity.ok().build();
    }
}
