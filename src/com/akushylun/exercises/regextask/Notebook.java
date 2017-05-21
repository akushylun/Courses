package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	
	private List<Record> records;
	
	public Notebook() {
		records = new ArrayList<>();
	}
	
	public void addRecord(Record record) {
		nicknameIsEmpty(record);
		records.add(record);
	}
	
	private boolean nicknameIsEmpty(Record comparedRecord) {
		for (Record record : records) {
			if (record.getNickname().equals(comparedRecord.getNickname())) {
				throw new NicknameException("Please change your login!");
			}
		}
		return true;
	}
	
	public List<Record> getRecords() {
		return records;
	}
	
	@Override
	public String toString() {
		return "Notebook [records=" + records + "]";
	}
	
}
