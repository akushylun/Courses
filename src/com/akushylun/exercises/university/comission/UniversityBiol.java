package com.akushylun.exercises.university.comission;

public class UniversityBiol extends University {
	
	public UniversityBiol(QueueProduceConsume handler, Student student) {
		super(handler, student);
	}
	
	@Override
	public void run() {
		synchronized (handler) {
			while (student.amountOfStudents > 0 || handler.containsStudent(student)) {
				while (handler.getSize() == 0 && student.amountOfStudents > 0) {
					try {
						handler.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("consume biol student ");
				if (handler.getSize() > 0) {
					handler.removeStudent();
				}
				handler.notify();
				try {
					Thread.sleep(70);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
