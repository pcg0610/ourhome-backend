package com.ourhome.user.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import com.ourhome.user.dto.UserCreateRequestDto;
import com.ourhome.user.dto.UserCredentialsDto;
import com.ourhome.user.dto.UserUpdateRequestDto;
import com.ourhome.user.entity.User;

@Mapper
@Repository
public interface UserDao {

    @Insert("INSERT INTO user (username, password, phone_number, birth, gender, profile_img_url) VALUE (#{username}, #{password}, #{phoneNumber}, #{birth}, #{gender}, #{profileImgUrl})")
    int save(UserCreateRequestDto createUserDto);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User findByUserCredentialsDto(UserCredentialsDto userCredentialsDto);

    @Select("SELECT COUNT(*) > 0 FROM user WHERE id = #{id}")
    boolean existsById(Long id);

    @Select("SELECT COUNT(*) > 0 FROM user WHERE username = #{username}")
    boolean existsByUsername(String username);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    int updateById(Long id, UserUpdateRequestDto userUpdateRequestDto);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Long id);

}
