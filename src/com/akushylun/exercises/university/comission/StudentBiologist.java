package com.akushylun.exercises.university.comission;

public class StudentBiologist extends Student {
	
	public StudentBiologist() {
	}
	
	public StudentBiologist(QueueProduceConsume handler, int amountOfStudents) {
		super(handler, amountOfStudents);
	}
	
	@Override
	public void run() {
		synchronized (handler) {
			System.out.println("student biol CLASS");
			while (amountOfStudents > 0) {
				while (handler.getSize() > 25) {
					try {
						handler.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("biology student " + amountOfStudents);
				handler.addStudent(new StudentBiologist());
				amountOfStudents = amountOfStudents - 1;
				handler.notify();
				try {
					Thread.sleep(50);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
