package com.ourhome.user.service;

import org.springframework.stereotype.Service;
import com.ourhome.user.dao.UserDao;
import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public int signUp(UserCreateRequestDto createUserDto) {
        return userDao.insertUser(createUserDto);
    }

    @Override
    public int deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int updateUserById(Long id, UserUpdateRequestDto updateUserDto) {
        return userDao.updateUserById(id, updateUserDto);
    }

    @Override
    public boolean exists(Long id) {
        return userDao.selectCountById(id);
    }

}
