package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Record {

    private String surname, name, patronymic, nameShort, nickname, comment;
    private Group group;
    private Address address;
    private String telHome, telMobile, telMobileOptional, email, skype;
    private Date dateOfCreation;
    private List<Date> dateOfLastChange = new ArrayList<Date>();

    public Record() {
    }

    public Record(String surname, String name, String patronymic, String nickname, String comment, Group group,
	    Address address, String telHome, String telMobile, String email, String skype, Date dateOfCreation) {
	this.surname = surname;
	this.name = name;
	this.patronymic = patronymic;
	this.nameShort = surname + " " + name.charAt(0) + ".";
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

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setPatronymic(String patronymic) {
	this.patronymic = patronymic;
    }

    public void setDateOfLastChange(List<Date> dateOfLastChange) {
	this.dateOfLastChange = dateOfLastChange;
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

    public enum Group {
	WORK, STUDY, REST, OTHER
    }

    @Override
    public String toString() {
	return "Record [surname=" + surname + ", name=" + name + ", patronymic=" + patronymic + ", nameShort="
		+ nameShort + ", nickname=" + nickname + ", comment=" + comment + ", group=" + group + ", address="
		+ address + ", telHome=" + telHome + ", telMobile=" + telMobile + ", telMobileOptional="
		+ telMobileOptional + ", email=" + email + ", skype=" + skype + ", dateOfCreation=" + dateOfCreation
		+ ", dateOfLastChange=" + dateOfLastChange + "]";
    }

}
