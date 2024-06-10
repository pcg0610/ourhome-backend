package com.ourhome.user.dao;

import org.apache.ibatis.jdbc.SQL;
import com.ourhome.user.dto.UserUpdateRequestDto;

public class UserProvider {

    public String updateUser(Long id, UserUpdateRequestDto userUpdateRequestDto) {
        return new SQL() {
            {
                UPDATE("user");

                if (userUpdateRequestDto.getPassword() != null) {
                    SET("password = #{userUpdateRequestDto.password}");
                }

                if (userUpdateRequestDto.getPhoneNumber() != null) {
                    SET("phone_number = #{userUpdateRequestDto.phoneNumber}");
                }

                if (userUpdateRequestDto.getProfileImgUrl() != null) {
                    SET("profile_img_url = #{userUpdateRequestDto.profileImgUrl}");
                }

                WHERE("id = #{id}");
            }
        }.toString();

    }
}
