package com.Anderson.homework5;

public class Procon {
	
	public static void main(String[] args) throws InterruptedException
	{
		final Procon pc = new Procon();
		
		Thread t1 = new Thread("producer")
				{
					public void run()
					{
						try {
							pc.produe();
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
			
				};
		Thread t2 = new Thread("consumer")
				{
					public void run()
					{
						try
						{
							pc.consume();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				};
				
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
	}
	
	int[] intArray= new int[2];
	int max =2;
	int count =-1;
	
	public void produe() throws InterruptedException
	{
		int value = 0;
		while(true)
		{
			synchronized(this)
			{
				while(count == max-1)
				wait();
				
				System.out.println("Produced " +value);
				count++;
				intArray[count] = value;
				value++;
				
				 notify();
				 Thread.sleep(100);
			}
		}
	}
	
	public void consume() throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				while(count == -1)
				wait();
				
				int val = intArray[count];
				System.out.println("Consumed " + val);
				count--;
				
				notify();
				Thread.sleep(100);
			}
		}
	}
	
}
