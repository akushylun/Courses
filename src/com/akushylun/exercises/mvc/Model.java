package com.akushylun.exercises.mvc;

public class Model {
	
	private String firstWord;
	
	private String secondWord;
	
	/**
	 * Concatenates first specified string with second specified string.
	 * 
	 * @param first first word
	 * @param second second word
	 * @return The resulting {@code String}
	 */
	public String concatenateTwoStrings(String first, String second) {
		return first + second;
	}
	
	public String getFirstWord() {
		return firstWord;
	}
	
	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}
	
	public String getSecondWord() {
		return secondWord;
	}
	
	public void setSecondWord(String secondWord) {
		this.secondWord = secondWord;
	}
	
}
