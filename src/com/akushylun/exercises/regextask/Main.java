package com.akushylun.exercises.regextask;

public class Main {
	
	public static void main(String[] args) {
		Notebook notebook = new Notebook();
		Record record = new Record();
		View view = new View();
		Controller controller = new Controller(notebook, record, view);
		
		controller.processUser();
	}
	
}
