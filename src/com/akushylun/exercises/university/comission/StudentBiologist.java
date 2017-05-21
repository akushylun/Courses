package com.akushylun.exercises.university.comission;

public class StudentBiologist extends Student implements Runnable {
	
	private QueueToAdd handler;
	
	private volatile boolean flag = true;
	
	private int amountOfStudents = 200;
	
	public StudentBiologist() {
	}
	
	public StudentBiologist(QueueToAdd handler) {
		this.handler = handler;
	}
	
	public boolean isNotEmptyList() {
		if (amountOfStudents > 1) {
			amountOfStudents = amountOfStudents - 1;
			flag = true;
		} else
			flag = false;
		return flag;
	}
	
	@Override
	public void run() {
		
		while (isNotEmptyList() != false) {
			synchronized (handler) {
				try {
					System.out.println("biol " + amountOfStudents);
					handler.addStudent(new StudentBiologist());
					handler.wait();
				}
				
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
