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

	while (!model.checkValue(inputIntValueWithScanner(sc))) {
	}

	view.printCongratulation(model);
	view.printWay(model);
    }

    private int inputIntValueWithScanner(Scanner sc) {

	int res = 0;
	boolean findedNumber = false;
	view.printMessage(view.getInputMessage(model.getLowerBoundary(), model.getUpperBoundary()));

	while (findedNumber != true) {
	    while (!sc.hasNextInt()) {
		view.printWrongIntInput(model);
		sc.next();
	    }
	    res = sc.nextInt();
	    if (checkBoundaryValid(res) == true) {
		findedNumber = true;
	    }
	}
	return res;
    }

    private boolean checkBoundaryValid(int res) {
	if (res <= model.getLowerBoundary() || res >= model.getUpperBoundary()) {
	    view.printWrongRangeInput(model);
	    return false;
	} else
	    return true;
    }
}
