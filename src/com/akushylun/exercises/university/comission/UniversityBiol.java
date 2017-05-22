package com.akushylun.exercises.university.comission;

public class UniversityBiol extends University {
	
	public UniversityBiol(QueueProduceConsume handler, Student student) {
		super(handler, student);
	}
	
	@Override
	public void run() {
		synchronized (handler) {
			while (student.amountOfStudents > 0) {
				while (student.amountOfStudents > 0 && handler.getSize() == 0
				        || handler.getStudent().getClass() != student.getClass()) {
					try {
						handler.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("consume biol student ");
				handler.removeStudent();
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
