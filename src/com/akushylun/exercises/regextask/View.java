package com.akushylun.exercises.regextask;

public class View {
	
	public static final String INPUT_DATA = "input.int.data";
	
	public static final String WRONG_INPUT_DATA = "input.wrong.data";
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public String concatenationString(String... message) {
		StringBuilder concatString = new StringBuilder();
		for (String v : message) {
			concatString = concatString.append(v);
		}
		return new String(concatString);
	}
	
	public void printNameInfo() {
		System.out.println("Need to enter: surname, name, patronymie");
	}
	
	public void printAddressInfo() {
		System.out.println("Need to enter: index, city, street, building, room");
	}
	
	public void printRecordObject() {
		System.out.println("nickname, comment, group, telHome, telMobile, email, skype");
	}
}
