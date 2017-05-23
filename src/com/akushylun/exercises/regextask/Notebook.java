package com.akushylun.exercises.regextask;

import java.util.ArrayList;
import java.util.List;

import com.akushylun.exercises.regextask.NicknameException.ErrorCode;

public class Notebook {

    private List<Record> recordList;

    public Notebook() {
	this.recordList = new ArrayList<>();
    }

    public boolean addRecord(Record record) throws NicknameException {
	boolean value = false;
	if (nicknameIsUnique(record)) {
	    recordList.add(record);
	    value = true;
	}
	return value;
    }

    /**
     * Check that {@code newRecord} doesn't exist in {@code List<Record>}
     * 
     * @param newRecord
     * @return {@code true} if {@code newRecord} doesn't exist in
     *         {@code List<Record>} or {@code NicknameException}
     * @throws NicknameException
     */
    private boolean nicknameIsUnique(Record newRecord) throws NicknameException {
	for (Record record : recordList) {
	    if (record.getNickname().equals(newRecord.getNickname())) {
		throw new NicknameException(ErrorCode.INVALID_NICKNAME, newRecord.getNickname());
	    }
	}
	return true;
    }

    @Override
    public String toString() {
	return "Notebook [records=" + recordList + "]";
    }

}
