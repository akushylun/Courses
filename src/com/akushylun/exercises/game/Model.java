package com.akushylun.exercises.game;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	public static final int DEFAULT_LOWER_BOUNDARY = 0;
	
	public static final int DEFAULT_UPPER_BOUNDARY = 100;
	
	private int lowerBoundary;
	
	private int upperBoundary;
	
	private int randomSecretInBoundary;
	
	private List<Integer> yourWay = new ArrayList<Integer>();
	
	public int rand(int min, int max) {
		this.lowerBoundary = min;
		this.upperBoundary = max;
		this.randomSecretInBoundary = (int) Math
		        .ceil(Math.random() * (getUpperBoundary() - getLowerBoundary() - 1) + getLowerBoundary());
		return randomSecretInBoundary;
	}
	
	public int rand() {
		this.randomSecretInBoundary = (int) Math
		        .ceil(Math.random() * (getUpperBoundary() - getLowerBoundary() - 1) + getLowerBoundary());
		return randomSecretInBoundary;
	}
	
	/**
	 * @param value entered value by User
	 * @return true if entered value by User equals {@code randomValueInBoundary}
	 */
	public boolean checkValue(int value) {
		yourWay.add(value);
		if (value == randomSecretInBoundary) {
			return true;
		} else if (value > randomSecretInBoundary) {
			upperBoundary = value;
		} else {
			lowerBoundary = value;
		}
		return false;
	}
	
	public void setBoundaries(int min, int max) {
		this.lowerBoundary = min;
		this.upperBoundary = max;
	}
	
	public int getLowerBoundary() {
		return lowerBoundary;
	}
	
	public int getUpperBoundary() {
		return upperBoundary;
	}
	
	public int getRandomSecretInBoundary() {
		return randomSecretInBoundary;
	}
	
	public List<Integer> getYourWay() {
		return yourWay;
	}
}
