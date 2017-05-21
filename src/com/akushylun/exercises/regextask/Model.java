package com.akushylun.exercises.regextask;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Model {
	
	private static final Pattern EMAIL_PATTERN = Pattern
	        .compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
	
	private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
	
	private static final Pattern OTHER_PATTERN = Pattern.compile("[A-Za-z]+");
	
	private Notebook notebook;
	private Record record;
	
	public Model() {
		this.notebook = new Notebook();
		this.record = new Record();
		
	}
	
	/**
	 * Method are used for simple adding a {@code Record} without Pattern checking
	 * @param record
	 */
	public void addRecord(Record record) {
		notebook.addRecord(record);
	}
	
	public Record checkInputValuesWithScanner(Scanner sc) {
		record.setName(checkValueWithPattern(sc, OTHER_PATTERN), checkValueWithPattern(sc, OTHER_PATTERN),
		    checkValueWithPattern(sc, OTHER_PATTERN));
		record.setNickname(checkValueWithPattern(sc, OTHER_PATTERN));
		record.setComment(checkValueWithPattern(sc, OTHER_PATTERN));
		record.setGroup(checkGroupValue(sc.next()));
		record.setTelMobile(checkValueWithPattern(sc, PHONE_PATTERN));
		record.setTelHome(checkValueWithPattern(sc, PHONE_PATTERN));
		record.setEmail(checkValueWithPattern(sc, EMAIL_PATTERN));
		record.setSkype(checkValueWithPattern(sc, OTHER_PATTERN));
		record.setAddress(new Address(checkValueWithPattern(sc, OTHER_PATTERN), checkValueWithPattern(sc, OTHER_PATTERN),
		        checkValueWithPattern(sc, OTHER_PATTERN), checkValueWithPattern(sc, OTHER_PATTERN),
		        checkValueWithPattern(sc, OTHER_PATTERN)));
		record.setDateOfCreation(Calendar.getInstance().getTime());
		return record;
	}
	
	public void changeNickname(Scanner sc) {
		record.setNickname(checkValueWithPattern(sc, OTHER_PATTERN));
		notebook.addRecord(record);
	}
	
	private String checkValueWithPattern(Scanner sc, Pattern pattern) {
		String recordField = sc.next();
		if (pattern.matcher(recordField).matches() == false) {
			System.out.println("There is mistake " + pattern);
			checkValueWithPattern(sc, pattern);
		}
		return recordField;
	}
	
	private Group checkGroupValue(String s) {
		String stringGroup = s.toLowerCase();
		switch (stringGroup) {
			case "WORK":
				return Group.WORK;
			case "STUDY":
				return Group.WORK;
			case "REST":
				return Group.REST;
			default:
				return Group.OTHER;
		}
		
	}
	
	@Override
	public String toString() {
		return "Model [notebook=" + notebook + ", record=" + record + "]";
	}
}
