package com.ourhome.user.service;

import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;
import com.ourhome.user.exception.DuplicateUsernameException;
import com.ourhome.user.exception.UserNotFoundException;

public interface UserService {

    public void signUp(UserCreateRequestDto createUserDto) throws DuplicateUsernameException;

    public User getUserById(Long id) throws UserNotFoundException;

    public void deleteAccount(Long id) throws UserNotFoundException;

    public void updateProfile(Long id, UserUpdateRequestDto updateUserDto)
            throws UserNotFoundException;

    public boolean exists(Long id) throws UserNotFoundException;
}
