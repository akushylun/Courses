package com.akushylun.exercises.regextask;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.akushylun.exercises.regextask.Record.Group;

public class Controller {

    private static final Pattern EMAIL_PATTERN = Pattern
	    .compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
    private static final Pattern OTHER_PATTERN = Pattern.compile("[A-Za-z]+");

    private Notebook notebook;
    private View view;

    public Controller(Notebook notebook, View view) {
	this.notebook = notebook;
	this.view = view;
    }

    public void processUser() {
	Scanner sc = new Scanner(System.in);
	Record record = checkInputValuesWithScanner(sc);
	try {
	    notebook.addRecord(record);
	    view.printMessage(View.SUCCESSFUL_ADDED_RECORD);
	} catch (NicknameException e) {
	    view.printMessage(View.WRONG_NICKNAME);
	    try {
		notebook.addRecord(changeRecordname(sc, record, OTHER_PATTERN));
	    } catch (NicknameException e1) {
		e1.printStackTrace();
	    }
	}
    }

    private Record checkInputValuesWithScanner(Scanner value) {
	String surname = (checkValueWithPattern(value, OTHER_PATTERN));
	String name = (checkValueWithPattern(value, OTHER_PATTERN));
	String patronymic = (checkValueWithPattern(value, OTHER_PATTERN));
	String nickname = (checkValueWithPattern(value, OTHER_PATTERN));
	String comment = (checkValueWithPattern(value, OTHER_PATTERN));
	Record.Group group = checkGroupValue(value.next());
	String telMobile = (checkValueWithPattern(value, PHONE_PATTERN));
	String telHome = (checkValueWithPattern(value, PHONE_PATTERN));
	String email = (checkValueWithPattern(value, EMAIL_PATTERN));
	String skype = (checkValueWithPattern(value, OTHER_PATTERN));
	Address address = (new Address(checkValueWithPattern(value, OTHER_PATTERN),
		checkValueWithPattern(value, OTHER_PATTERN), checkValueWithPattern(value, OTHER_PATTERN),
		checkValueWithPattern(value, OTHER_PATTERN), checkValueWithPattern(value, OTHER_PATTERN)));
	Date dateOfCreation = (Calendar.getInstance().getTime());
	return new Record(surname, name, patronymic, nickname, comment, group, address, telHome, telMobile, email,
		skype, dateOfCreation);
    }

    private Record changeRecordname(Scanner value, Record record, Pattern pattern) {
	checkValueWithPattern(value, pattern);
	record.setNickname(value.next());
	return record;
    }

    private String checkValueWithPattern(Scanner value, Pattern pattern) {
	String getValue = value.next();
	while (pattern.matcher(getValue).matches() == false) {
	    view.printMessage(View.WRONG_INPUT_DATA);
	    checkValueWithPattern(value, pattern);
	}
	return getValue;
    }

    private Group checkGroupValue(String value) {
	String valueLowerCase = value.toLowerCase();
	switch (valueLowerCase) {
	case "WORK":
	    return Record.Group.WORK;
	case "STUDY":
	    return Record.Group.WORK;
	case "REST":
	    return Record.Group.REST;
	default:
	    return Record.Group.OTHER;
	}
    }
}