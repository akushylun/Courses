package com.akushylun.exercises.reflection;

import java.io.Serializable;

public class Truck extends Car implements Serializable, TrucksNames {

    private int carryingCapacity;

    public Truck(String mark, int cylinderAmount, int power, int carryingCapacity) {
	super(mark, cylinderAmount, power);
	this.carryingCapacity = carryingCapacity;
    }

    @CallMe
    public int getCarryingCapacity() {
	return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
	this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
	return "Truck [carryingCapacity=" + carryingCapacity + ", getMark()=" + getMark() + ", getCylinderAmount()="
		+ getCylinderAmount() + ", getPower()=" + getPower() + "]";
    }

}
