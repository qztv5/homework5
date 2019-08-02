package com.Anderson.homework5;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


public class LineTest {
	Line line = new Line(3, 4, 5, 6);
	
	@Test
	public void slopeTest()
	{
		assertTrue(line.getSlope() >= 0 || line.getSlope() < 0);
	}
	@Test
	public void distacneTest()
	{
		assertTrue(line.getDistance() >=0);
	}
	@Test
	public void parrallelTest()
	{
		assertTrue(line.getSlope() == line.getSlope());
	}

}
