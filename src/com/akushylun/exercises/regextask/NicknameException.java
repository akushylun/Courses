package com.akushylun.exercises.regextask;

public class NicknameException extends Exception {
    private String errorNickname;
    private ErrorCode errorCode = ErrorCode.INVALID_NICKNAME;
    private static final long serialVersionUID = 6483612798401795931L;

    public NicknameException() {
	super();
    }

    public NicknameException(String message) {
	super(message);
    }

    public NicknameException(ErrorCode errorCode, String errorNickname) {
	this.errorCode = errorCode;
	this.errorNickname = errorNickname;
    }

    public String errorMessage() {
	switch (errorCode) {
	case INVALID_NICKNAME:
	    return "Please change your NICKNAME";
	}
	return "";
    }

    public enum ErrorCode {
	INVALID_NICKNAME
    }
}
