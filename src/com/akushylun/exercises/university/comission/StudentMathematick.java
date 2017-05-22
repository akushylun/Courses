package com.akushylun.exercises.university.comission;

public class StudentMathematick extends Student {
	
	public StudentMathematick() {
	}
	
	public StudentMathematick(QueueProduceConsume handler, int amountOfStudents) {
		super(handler, amountOfStudents);
	}
	
	@Override
	public void run() {
		synchronized (handler) {
			while (amountOfStudents > 0) {
				while (handler.getSize() > 25) {
					try {
						handler.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("mathematics studemt " + amountOfStudents);
				handler.addStudent(new StudentMathematick());
				amountOfStudents = amountOfStudents - 1;
				handler.notify();
			}
		}
	}
}
