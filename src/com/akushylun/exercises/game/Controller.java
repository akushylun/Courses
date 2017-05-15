package com.akushylun.exercises.game;

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
		
		model.setBoundaries(Model.DEFAULT_LOWER_BOUNDARY, Model.DEFAULT_UPPER_BOUNDARY);
		model.rand();
		System.out.println(model.getRandomSecretInBoundary());
		
		while (!model.checkValue(inputIntValueWithScanner(sc))) {}
		
		view.printCongratulation(model);
		view.printWay(model);
	}
	
	private int inputIntValueWithScanner(Scanner sc) {
		int res = 0;
		view.printMessage(view.getInputMessage(model.getLowerBoundary(), model.getUpperBoundary()));
		
		while (true) {
			while (!sc.hasNextInt()) {
				view.printWrongIntInput(model);
				sc.next();
			}
			if ((res = sc.nextInt()) <= model.getLowerBoundary() || res >= model.getUpperBoundary()) {
				view.printWrongRangeInput(model);
				continue;
			}
			break;
		}
		return res;
	}
}
