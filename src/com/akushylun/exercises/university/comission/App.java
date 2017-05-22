package com.akushylun.exercises.university.comission;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		
		QueueProduceConsume handler = new QueueProduceConsume();
		
		Student studentBiol = new StudentBiologist(handler, 200);
		Student studentMath = new StudentMathematick(handler, 250);
		
		University biolUniversity = new UniversityBiol(handler, studentBiol);
		University mathUniversity = new UniversityMath(handler, studentMath);
		University mixUniversity = new UniversityMix(handler, studentBiol, studentMath);
		
		Thread biolStudentThread = new Thread(studentBiol);
		Thread mathStudentThread = new Thread(studentMath);
		
		Thread biolUniversityThread = new Thread(biolUniversity);
		Thread mathUniversityThread = new Thread(mathUniversity);
		Thread mixUniversityThread = new Thread(mixUniversity);
		
		biolStudentThread.start();
		mathStudentThread.start();
		biolUniversityThread.start();
		mathUniversityThread.start();
		mixUniversityThread.start();
		
	}
}
