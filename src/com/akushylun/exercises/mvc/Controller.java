package com.akushylun.exercises.mvc;

import java.util.Scanner;

public class Controller {
	
	public static final String FIRST_WORD_PATTERN = "Hello";
	
	public static final String SECOND_WORD_PATTERN = "world!";
	
	// Constructor
	Model model;
	
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	// The Work method
	public void processUser() {
		Scanner scFirst = new Scanner(System.in);
		model.setFirstWord(inputStringValueWithScanner(scFirst, FIRST_WORD_PATTERN));
		Scanner scSecond = new Scanner(System.in);
		model.setSecondWord(inputStringValueWithScanner(scSecond, SECOND_WORD_PATTERN));
		
		view.printMessage(model.concatenateTwoStrings(model.getFirstWord(), model.getSecondWord()));
	}
	
	// The Utility methods
	public String inputStringValueWithScanner(Scanner sc, final String pattern) {
		view.printMessage(View.INPUT_STRING_DATA);
		while (!sc.hasNext(pattern)) {
			view.printMessage(View.WRONG_INPUT_STRING_DATA + "\n" + View.INPUT_STRING_DATA);
			sc.next();
		}
		return sc.next();
	}
	
}
