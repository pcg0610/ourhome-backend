package com.ourhome.user.service;

import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

public interface UserService {

    public User getUserById(Long id);

    public int signUp(UserCreateRequestDto createUserDto);

    public int deleteUserById(Long id);

    public int updateUserById(Long id, UserUpdateRequestDto updateUserDto);

    public boolean exists(Long id);
}
