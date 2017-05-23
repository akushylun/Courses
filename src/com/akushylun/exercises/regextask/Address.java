package com.akushylun.exercises.regextask;

public class Address {

    private String index, city, street, building, room;

    private String fullAddress;

    public Address(String index, String city, String street, String building, String room) {
	this.index = index;
	this.city = city;
	this.street = street;
	this.building = building;
	this.room = room;
	this.fullAddress = index + " " + city + " " + street + " " + building + " " + room;
    }

    @Override
    public String toString() {
	return "Address [index=" + index + ", city=" + city + ", street=" + street + ", building=" + building
		+ ", room=" + room + ", fullAddress=" + fullAddress + "]";
    }

}
