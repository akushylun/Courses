package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	
	private List<Record> records;
	
	public Notebook() {
		records = new ArrayList<>();
	}
	
	public void addRecord(Record record) {
		records.add(record);
	}
	
	public List<Record> getRecords() {
		return records;
	}
	
	@Override
	public String toString() {
		return "Notebook [records=" + records + "]";
	}
	
}
