package com.akushylun.exercises.game;

public class View {
	
	public static final String INPUT_INT_DATA_KEY = "input.int.data";
	
	public static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
	
	public static final String WRONG_RANGE_DATA = "input.wrong.range";
	
	public static final String CONGRATULATION = "input.congratulation";
	
	public static final String YOUR_WAY = "input.way";
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public String concatenationString(String... message) {
		StringBuilder concatString = new StringBuilder();
		for (String v : message) {
			concatString = concatString.append(v);
		}
		return new String(concatString);
	}
	
	String getInputMessage(int minBarrier, int maxBarrier) {
		String str = concatenationString(INPUT_INT_DATA_KEY, String.valueOf(minBarrier), String.valueOf(maxBarrier));
		return str;
	}
	
	void printWrongRangeInput(Model model) {
		printMessage(WRONG_RANGE_DATA + getInputMessage(model.getLowerBoundary(), model.getUpperBoundary()));
	}
	
	void printWrongIntInput(Model model) {
		printMessage(WRONG_INPUT_INT_DATA + getInputMessage(model.getLowerBoundary(), model.getUpperBoundary()));
	}
	
	void printCongratulation(Model model) {
		printMessage(CONGRATULATION + model.getRandomSecretInBoundary());
	}
	
	void printWay(Model model) {
		printMessage(YOUR_WAY + String.valueOf(model.getYourWay()));
	}
}
