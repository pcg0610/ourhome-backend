package com.ourhome.user.dto;

public class UserUpdateRequestDto {

    private String password;

    private String phoneNumber;

    private String profileImgUrl;

    public UserUpdateRequestDto() {}

    public UserUpdateRequestDto(String password, String phoneNumber, String profileImgUrl) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profileImgUrl = profileImgUrl;
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

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String image) {
        this.profileImgUrl = image;
    }

}
