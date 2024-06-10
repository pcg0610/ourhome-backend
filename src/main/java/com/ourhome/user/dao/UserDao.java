package com.ourhome.user.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

@Mapper
@Repository
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserById(Long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectUserByUsername(String username);

    @Insert("INSERT INTO user (username, password, phone_number, birth, gender, profile_img_url) VALUE (#{username}, #{password}, #{phoneNumber}, #{birth}, #{gender}, #{profileImgUrl})")
    int insertUser(UserCreateRequestDto createUserDto);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUserById(Long id);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    int updateUserById(Long id, UserUpdateRequestDto userUpdateRequestDto);

    @Select("SELECT COUNT(*) > 0 FROM user WHERE id = #{id}")
    boolean selectCountById(Long id);

}
