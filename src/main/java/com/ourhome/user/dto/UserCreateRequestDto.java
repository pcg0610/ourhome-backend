package com.ourhome.user.dto;

import java.util.Date;

public class UserCreateRequestDto {

    private String username;
    private String password;
    private String phoneNumber;
    private Date birth;
    private char gender;
    private String profileImgUrl;

    public UserCreateRequestDto() {}

    public UserCreateRequestDto(String username, String password, String phoneNumber, Date birth,
            char gender, String profileImgUrl) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.gender = gender;
        this.profileImgUrl = profileImgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userId) {
        this.username = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String image) {
        this.profileImgUrl = image;
    }
}
