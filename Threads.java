package com.Anderson.homework5;

public class Threads {
	
	String num1 = "5";
	String num2 = "12";
	
	Thread t1 = new Thread("Thread 1")
			{
				public void run() {
					while(true) {
						synchronized(num1){
							synchronized(num2) {
								System.out.println(num1 + " " + num2);
							}
						}
					}
				}
			};
			
			Thread t2 = new Thread("Thread 2")
			{
				public void run() {
					while(true) {
						synchronized(num2){
							synchronized(num1) {
								System.out.println(num2 + " " + num1);
							}
						}
					}
				}
			};

	public static void main(String[] args)
	{
		Threads dlk = new Threads();
		dlk.t2.start();
		dlk.t1.start();
		
	}
	
}
