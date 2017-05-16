package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Record {
	
	private String name;
	
	public String buildShortenedName(String surname, String name, String patronymic) {
		return (surname + " " + name.charAt(0) + ".");
	}
	
	private String nickname;
	private String comment;
	private Group group;
	private String telHome;
	private String telMobile;
	private String email;
	private String skype;
	private String telMobileOptional;
	
	public void setRecordArgs(String name, String address, String nickname, String comment, Group group, String telHome,
	        String telMobile, String email, String skype) {
		this.name = name;
		this.nickname = nickname;
		this.comment = comment;
		this.group = group;
		this.telHome = telHome;
		this.telMobile = telMobile;
		this.email = email;
		this.skype = skype;
		this.dateOfCreation = Calendar.getInstance().getTime();
	}
	
	public void setEmail(String email) {
		addDateOfLastChange();
		this.email = email;
	}
	
	public void setTelMobileOptional(String telMobileOptional) {
		this.telMobileOptional = telMobileOptional;
	}
	
	private Date dateOfCreation;
	
	private List<Date> dateOfLastChange = new ArrayList<Date>();
	
	public void addDateOfLastChange() {
		Calendar cal = Calendar.getInstance();
		dateOfLastChange.add(cal.getTime());
	}
	
	public String buildShortenedAdress(String index, String city, String street, String building, String room) {
		return new Address().getFullAddress(index, city, street, building, room);
	}
	
	private class Address {
		
		private String fullAddress;
		public String getFullAddress(String index, String city, String street, String building, String room) {
			fullAddress = index + " " + city + " " + street + " " + building + " " + room;
			return fullAddress;
		}
	}
	
	@Override
	public String toString() {
		return "Record [nameInfo=" + name + ", nickname=" + nickname + ", comment=" + comment + ", group=" + group
		        + ", telHome=" + telHome + ", telMobile=" + telMobile + ", email=" + email + ", skype=" + skype
		        + ", telMobileOptional=" + telMobileOptional + ", enteredChanges=" + dateOfCreation + ", lastChange="
		        + dateOfLastChange + "]";
	}
	
}
