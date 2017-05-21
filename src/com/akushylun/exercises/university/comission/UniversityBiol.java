package com.akushylun.exercises.university.comission;

public class UniversityBiol implements University, Runnable {
	
	private QueueToAdd handler;
	
	private volatile boolean flag = true;
	
	public UniversityBiol(QueueToAdd handler) {
		this.handler = handler;
	}
	
	public boolean stopThread() {
		flag = false;
		return flag;
	}
	
	@Override
	public void run() {
		while (flag != false) {
			synchronized (handler) {
				while (handler.getSize() != 0) {
					System.out.println("remove student " + handler.getSize());
					handler.removeStudent();
				}
			}
		}
	}
}
