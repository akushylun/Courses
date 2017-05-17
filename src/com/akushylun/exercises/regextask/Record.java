package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Record {
	
	private String name;
	private String nickname;
	private String comment;
	private Group group;
	private String telHome;
	private String telMobile;
	private String email;
	private String skype;
	private String telMobileOptional;
	private Date dateOfCreation;
	private List<Date> dateOfLastChange = new ArrayList<Date>();
	
	public void setName(String surname, String name, String patronymic) {
		this.name = (surname + " " + name.charAt(0) + ".");
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}
	
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSkype(String skype) {
		this.skype = skype;
	}
	
	public void setTelMobileOptional(String telMobileOptional) {
		this.telMobileOptional = telMobileOptional;
	}
	
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public void addDateOfLastChange() {
		Calendar cal = Calendar.getInstance();
		dateOfLastChange.add(cal.getTime());
	}
	
	public void setFullAdress(String index, String city, String street, String building, String room) {
		Address address = new Address();
		address.setFullAddress(index, city, street, building, room);
	}
	
	private class Address {
		private String fullAddress;
		private void setFullAddress(String index, String city, String street, String building, String room) {
			this.fullAddress = index + " " + city + " " + street + " " + building + " " + room;
		}
		
	}
	
	@Override
	public String toString() {
		return "Record [name=" + name + ", nickname=" + nickname + ", comment=" + comment + ", group=" + group + ", telHome="
		        + telHome + ", telMobile=" + telMobile + ", email=" + email + ", skype=" + skype + ", telMobileOptional="
		        + telMobileOptional + ", dateOfCreation=" + dateOfCreation + ", dateOfLastChange=" + dateOfLastChange + "]";
	}
	

}
