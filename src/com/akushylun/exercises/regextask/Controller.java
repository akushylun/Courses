package com.akushylun.exercises.regextask;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
	
	Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
	Pattern textPattern = Pattern.compile("[A-Za-z]+");
	Pattern phonePattern = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
	
	Record record;
	Notebook notebook;
	View view;
	
	public Controller(Notebook notebook, Record record, View view) {
		this.notebook = notebook;
		this.record = record;
		this.view = view;
	}
	
	public void processUser() {
		fillRecord(record);
		notebook.addRecord(record);
		view.printMessage(View.SUCCESSFUL_ADDED_RECORD);
		
	}
	
	private void fillRecord(Record record) {
		Scanner sc = new Scanner(System.in);
		record.setName(checkInput(sc, textPattern), checkInput(sc, textPattern), checkInput(sc, textPattern));
		record.setNickname(checkInput(sc, textPattern));
		record.setComment(checkInput(sc, textPattern));
		record.setGroup(Group.valueOf(sc.next()));
		record.setTelMobile(checkInput(sc, phonePattern));
		record.setTelHome(checkInput(sc, phonePattern));
		record.setEmail(checkInput(sc, emailPattern));
		record.setSkype(checkInput(sc, textPattern));
		record.setFullAdress(checkInput(sc, textPattern), checkInput(sc, textPattern), checkInput(sc, textPattern),
		    checkInput(sc, textPattern), checkInput(sc, textPattern));
		record.setDateOfCreation(Calendar.getInstance().getTime());
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
