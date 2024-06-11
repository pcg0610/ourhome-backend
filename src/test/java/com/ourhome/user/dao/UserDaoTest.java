package com.ourhome.user.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Order(1)
    public void testInsertUser() {
        // Given
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto("testId",
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        // When
        int result = userDao.insertUser(userCreateRequestDto);

        // Then
        assertEquals(1, result);
    }

    @Test
    @Order(2)
    public void testSelectUserByUsername() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        // When
        User user = userDao.selectUserByUsername(username);

        // Then
        assertEquals(username, user.getUsername());
    }

    @Test
    @Order(3)
    public void testSelectUserById() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        User user = userDao.selectUserByUsername(username);

        // When
        User selectedUser = userDao.selectUserById(user.getId());

        // Then
        assertEquals(user, selectedUser);
    }

    @Test
    @Order(4)
    public void testDeleteUserById() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        User user = userDao.selectUserByUsername(username);

        // When
        int result = userDao.deleteUserById(user.getId());

        // Then
        assertEquals(1, result);
    }

    @Test
    @Order(5)
    public void testUpdateUserById() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        User user = userDao.selectUserByUsername(username);

        UserUpdateRequestDto userUpdateRequestDto =
                new UserUpdateRequestDto("updatePassword", "010-0000-0000", "updateImagePath");

        // When
        int result = userDao.updateUserById(user.getId(), userUpdateRequestDto);
        User updatedUser = userDao.selectUserByUsername(username);

        // Then
        assertEquals(1, result);
        assertEquals(userUpdateRequestDto.getPassword(), updatedUser.getPassword());
        assertEquals(userUpdateRequestDto.getPhoneNumber(), updatedUser.getPhoneNumber());
        assertEquals(userUpdateRequestDto.getProfileImgUrl(), updatedUser.getProfileImgUrl());
    }

    @Test
    @Order(6)
    public void testSelectCountById() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        User user = userDao.selectUserByUsername(username);

        // When
        boolean result = userDao.selectCountById(user.getId());

        // Then
        assertEquals(true, result);
    }

    @Test
    @Order(7)
    public void testInsertDuplicateUsername() {
        // Given
        String username = "testId";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(username,
                "testPassword", "010-1234-5678", new Date(), 'M', "testImage");

        userDao.insertUser(userCreateRequestDto);

        UserCreateRequestDto duplUserCreateRequestDto = new UserCreateRequestDto(username,
                "duplPassword", "010-9999-9999", new Date(), 'F', "duplImg");

        // When
        // Then
        assertThrows(org.springframework.dao.DuplicateKeyException.class, () -> {
            userDao.insertUser(duplUserCreateRequestDto);
        });
    }
}
