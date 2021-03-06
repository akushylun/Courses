package com.akushylun.exercises.university.comission;

public class UniversityMix extends University {
	
	public UniversityMix(QueueProduceConsume handler, Student student, Student student2) {
		super(handler, student, student2);
	}
	
	@Override
	public void run() {
		final int MIN = 1;
		final int MAX = 5;
		
		synchronized (handler) {
			int randomNum = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
			while (handler.containsStudent(student) || handler.containsStudent(studen2)) {
				if (randomNum < 1) {
					try {
						handler.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("consume mix student ");
				handler.removeStudent();
				randomNum = randomNum - 1;
				System.out.println(randomNum);
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
