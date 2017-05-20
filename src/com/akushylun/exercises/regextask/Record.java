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
	private Address address;
	private String telHome;
	private String telMobile;
	private String email;
	private String skype;
	private String telMobileOptional;
	private Date dateOfCreation;
	private List<Date> dateOfLastChange = new ArrayList<Date>();
	
	public Record() {
	}
	
	public Record(String name, String nickname, String comment, Group group, Address address, String telHome,
	    String telMobile, String email, String skype, Date dateOfCreation) {
		this.name = name;
		this.nickname = nickname;
		this.comment = comment;
		this.group = group;
		this.address = address;
		this.telHome = telHome;
		this.telMobile = telMobile;
		this.email = email;
		this.skype = skype;
		this.dateOfCreation = dateOfCreation;
	}
	
	public void setName(String surname, String name, String patronymic) {
		this.name = (surname + " " + name.charAt(0) + ".");
	}
	
	public void setNickname(String nickname) {
		addDateOfLastChange();
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setComment(String comment) {
		addDateOfLastChange();
		this.comment = comment;
	}
	
	public void setGroup(Group group) {
		addDateOfLastChange();
		this.group = group;
	}
	
	public void setAddress(Address address) {
		addDateOfLastChange();
		this.address = address;
	}
	
	public void setTelHome(String telHome) {
		addDateOfLastChange();
		this.telHome = telHome;
	}
	
	public void setTelMobile(String telMobile) {
		addDateOfLastChange();
		this.telMobile = telMobile;
	}
	
	public void setEmail(String email) {
		addDateOfLastChange();
		this.email = email;
	}
	
	public void setSkype(String skype) {
		addDateOfLastChange();
		this.skype = skype;
	}
	
	public void setTelMobileOptional(String telMobileOptional) {
		addDateOfLastChange();
		this.telMobileOptional = telMobileOptional;
	}
	
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	private void addDateOfLastChange() {
		if (this.dateOfCreation != null) {
			Calendar cal = Calendar.getInstance();
			dateOfLastChange.add(cal.getTime());
		}
	}
	
	@Override
	public String toString() {
		return "Record [name=" + name + ", nickname=" + nickname + ", comment=" + comment + ", group=" + group + ", address="
		        + address + ", telHome=" + telHome + ", telMobile=" + telMobile + ", email=" + email + ", skype=" + skype
		        + ", telMobileOptional=" + telMobileOptional + ", dateOfCreation=" + dateOfCreation + ", dateOfLastChange="
		        + dateOfLastChange + "]";
	}
	
}
