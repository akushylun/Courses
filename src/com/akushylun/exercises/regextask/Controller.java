package com.akushylun.exercises.regextask;

import java.util.Scanner;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		try {
			Record record = model.checkInputValuesWithScanner(sc);
			model.addRecord(record);
		}
		catch (NicknameException ex) {
			view.printMessage(ex.toString());
			model.changeNickname(sc);
		}
		System.out.println(model.toString());
		view.printMessage(View.SUCCESSFUL_ADDED_RECORD);
	}
}
