package com.akushylun.exercises.regextask;

import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) {
		
		Record record = new Record("kushylun", "akushylun", "task4", Group.STUDY,
		        new Address("32131", "Kyiv", "Shevchenko", "1a", "55"), "+38(067)123-45-67", "+38(067)123-45-67",
		        "akushylun@gmail.com", "skype", Calendar.getInstance().getTime());
		
		Model model = new Model();
		model.addRecordWithoutPatternChecking(record);
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.processUser();
	}
}
