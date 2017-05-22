package com.akushylun.exercises.university.comission;

public abstract class University implements Runnable {
	
	public QueueProduceConsume handler;
	
	public Student student;
	
	public Student studen2;
	
	public University(QueueProduceConsume handler, Student student) {
		this.handler = handler;
		this.student = student;
	}
	
	public University(QueueProduceConsume handler, Student student, Student student2) {
		this.handler = handler;
		this.student = student;
		this.studen2 = student2;
	}
}
