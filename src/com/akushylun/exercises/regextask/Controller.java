package com.akushylun.exercises.regextask;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
	
	Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
	
	Pattern nameInfoPattern = Pattern.compile("[A-Za-z]+");
	
	Pattern phonePattern = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
	
	Record record;
	
	View view;
	
	public Controller(Record record, View view) {
		this.record = record;
		this.view = view;
	}
	
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		
		view.printNameInfo();
		String name = record.buildShortenedName(checkInput(sc, nameInfoPattern), checkInput(sc, nameInfoPattern),
		    checkInput(sc, nameInfoPattern));
		
		view.printAddressInfo();
		String address = record.buildShortenedAdress(checkInput(sc, nameInfoPattern), checkInput(sc, nameInfoPattern),
		    checkInput(sc, nameInfoPattern), checkInput(sc, nameInfoPattern), checkInput(sc, nameInfoPattern));
		
		view.printRecordObject();
		record.setRecordArgs(name, address, checkInput(sc, nameInfoPattern), checkInput(sc, nameInfoPattern),
		    Group.valueOf(sc.next()), checkInput(sc, phonePattern), checkInput(sc, phonePattern),
		    checkInput(sc, emailPattern), checkInput(sc, nameInfoPattern));
		
		record.setEmail(checkInput(sc, emailPattern));
		
		System.out.println(record.toString());
		
	}
	
	private String checkInput(Scanner sc, Pattern pattern) {
		String s = sc.next();
		if (pattern.matcher(s).matches() == false) {
			view.printMessage(View.WRONG_INPUT_DATA + s + " " + pattern);
			checkInput(sc, pattern);
		}
		return s;
	}
	
}
