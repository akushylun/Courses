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
		while(!model.checkInputValuesWithScanner(sc)){};
		view.printMessage(View.SUCCESSFUL_ADDED_RECORD);
	}
}
