package com.akushylun.exercises.university.comission;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		QueueToAdd handler = new QueueToAdd();
		Thread biolThread = new Thread(new StudentBiologist(handler));
		Thread mathThread = new Thread(new StudentMathematick(handler));
		UniversityBiol biol = new UniversityBiol(handler);
		Thread biolUniversityThread = new Thread(biol);
		biolThread.start();
		mathThread.start();
		biolUniversityThread.start();
		
		addStudentsInQueue(handler, biolThread, mathThread, biol);
		
	}
	
	public static void addStudentsInQueue(QueueToAdd handler, Thread biolThread, Thread mathThread, UniversityBiol biol) {
		while (biolThread.isAlive() || mathThread.isAlive()) {
			int amountOfAdding = 50;
			if (handler.getSize() < 25 && (biolThread.isAlive() || mathThread.isAlive())) {
				int tillAdd = handler.getSize() + amountOfAdding;
				while (handler.getSize() < tillAdd && (biolThread.isAlive() || mathThread.isAlive())) {
					synchronized (handler) {
						handler.notifyAll();
					}
				}
			}
		}
		biol.stopThread();
	}
	
}
