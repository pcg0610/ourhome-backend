package com.ourhome.user.service;

import org.springframework.stereotype.Service;
import com.ourhome.user.dao.UserDao;
import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;
import com.ourhome.user.exception.DuplicateUsernameException;
import com.ourhome.user.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void signUp(UserCreateRequestDto createUserDto) throws DuplicateUsernameException {

        boolean exist = userDao.existsByUsername(createUserDto.getUsername());

        if (exist) {
            throw new DuplicateUsernameException();
        }
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {

        User user = userDao.findById(id);

        if (user == null) {
            throw new UserNotFoundException("아이디가 " + id + "인 사용자는 존재하지 않습니다.");
        }

        return user;
    }

    @Override
    public boolean exists(Long id) throws UserNotFoundException {

        boolean result = userDao.existsById(id);

        if (!result) {
            throw new UserNotFoundException("아이디가 " + id + "인 사용자는 존재하지 않습니다.");
        }

        return result;
    }

    @Override
    public void updateProfile(Long id, UserUpdateRequestDto userUpdateRequestDto)
            throws UserNotFoundException {

        int result = userDao.updateById(id, userUpdateRequestDto);

        if (result != 0) {
            throw new UserNotFoundException("아이디가 " + id + "인 사용자는 존재하지 않습니다.");
        }
    }

    @Override
    public void deleteAccount(Long id) throws UserNotFoundException {

        int result = userDao.deleteById(id);

        if (result != 0) {
            throw new UserNotFoundException("아이디가 " + id + "인 사용자는 존재하지 않습니다.");
        }
    }
}
