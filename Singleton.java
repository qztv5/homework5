package com.Anderson.homework5;

public class Singleton {
	
	private static volatile Singleton _single;
	
	public static Singleton getInsatnce() {
		if(_single == null)
			synchronized(Singleton.class) {
				if(_single == null)
				{
					_single = new Singleton();
				}
			}
		return _single;
		
	}

}
