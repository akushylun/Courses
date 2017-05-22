package com.akushylun.exercises.university.comission;

import java.util.LinkedList;

public class QueueProduceConsume {
	
	private LinkedList<Student> list = new LinkedList<>();
	
	public synchronized void addStudent(Student student) {
		synchronized (list) {
			list.add(student);
		}
	}
	
	public void removeStudent() {
		synchronized (list) {
			list.removeFirst();
		}
	}
	
	public Student getStudent() {
		return list.getFirst();
	}
	
	public boolean containsStudent(Student s) {
		return list.contains(s);
	}
	
	public int getSize() {
		return list.size();
	}
}
