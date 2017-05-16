package com.akushylun.exercises.regextask;

public class Main {
	
	public static void main(String[] args) {
		Record record = new Record();
		View view = new View();
		Controller controller = new Controller(record, view);
		
		controller.processUser();
	}
	
}
