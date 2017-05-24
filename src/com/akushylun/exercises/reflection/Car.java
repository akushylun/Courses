package com.akushylun.exercises.reflection;

public class Car {
    private String mark;
    private int cylinderAmount;
    private int power;

    public Car(String mark, int cylinderAmount, int power) {
	this.mark = mark;
	this.cylinderAmount = cylinderAmount;
	this.power = power;
    }

    public String getMark() {
	return mark;
    }

    public void setMark(String mark) {
	this.mark = mark;
    }

    @CallMe
    public int getCylinderAmount() {
	return cylinderAmount;
    }

    public void setCylinderAmount(int cylinderAmount) {
	this.cylinderAmount = cylinderAmount;
    }

    public int getPower() {
	return power;
    }

    public void setPower(int power) {
	this.power = power;
    }

    @Override
    public String toString() {
	return "Car [mark=" + mark + ", cylinderAmount=" + cylinderAmount + ", power=" + power + "]";
    }

}
