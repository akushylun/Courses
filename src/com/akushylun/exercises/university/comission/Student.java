package com.akushylun.exercises.university.comission;

public abstract class Student implements Runnable {
	
	public QueueProduceConsume handler;
	
	public int amountOfStudents;
	
	public Student() {
		
	}
	
	public Student(QueueProduceConsume handler, int amountOfStudents) {
		this.handler = handler;
		this.amountOfStudents = amountOfStudents;
	}
	
}
