package com.akushylun.exercises.regextask;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws NicknameException {

	Record record = new Record("kushylun", "andriy", "olexandrovych", "akushylun", "task4", Record.Group.STUDY,
		new Address("32131", "Kyiv", "Shevchenko", "1a", "55"), "+38(067)123-45-67", "+38(067)123-45-67",
		"akushylun@gmail.com", "skype", Calendar.getInstance().getTime());

	Notebook notebook = new Notebook();
	notebook.addRecord(record);
	View view = new View();
	Controller controller = new Controller(notebook, view);
	controller.processUser();
    }
}
