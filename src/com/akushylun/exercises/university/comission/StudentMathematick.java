package com.akushylun.exercises.university.comission;

public class StudentMathematick extends Student implements Runnable {
	
	private QueueToAdd handler;
	
	private volatile boolean flag = true;
	
	private int amountOfStudents = 250;
	
	public StudentMathematick() {
	}
	
	public StudentMathematick(QueueToAdd handler) {
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
			System.out.println(isNotEmptyList());
			synchronized (handler) {
				try {
					System.out.println("math " + amountOfStudents);
					handler.addStudent(new StudentMathematick());
					handler.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
