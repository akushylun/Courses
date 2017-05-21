package com.akushylun.exercises.university.comission;

import java.util.LinkedList;

public class QueueToAdd {
	
	private LinkedList<Student> list = new LinkedList<>();
	
	public synchronized void addStudent(Student student) {
		list.add(student);
	}
	
	public Student removeStudent() {
		return list.removeFirst();
	}
	
	public int getSize() {
		return list.size();
	}
}
