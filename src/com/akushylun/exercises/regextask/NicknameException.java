package com.akushylun.exercises.regextask;

public class NicknameException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 6483612798401795931L;
	
	public NicknameException() {
		super();
	}
	
	public NicknameException(String message) {
		super(message);
	}
}
