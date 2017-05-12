package com.akushylun.exercises.mvc;

public class App {
	
	public static void main(String[] args) {
		// Initialization
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		// Run
		controller.processUser();
	}
}
