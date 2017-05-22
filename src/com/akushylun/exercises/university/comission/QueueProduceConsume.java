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
			if (list.isEmpty()) {
				return;
			}
			list.removeFirst();
		}
	}
	
	public Student getStudent() {
		return list.getFirst();
	}
	
	public int getSize() {
		return list.size();
	}
}
