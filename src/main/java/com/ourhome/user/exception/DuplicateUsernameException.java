package com.ourhome.user.exception;

public class DuplicateUsernameException extends RuntimeException {

    public DuplicateUsernameException() {
        super("중복된 아이디입니다.");
    }

    public DuplicateUsernameException(String message) {
        super(message);
    }
}
