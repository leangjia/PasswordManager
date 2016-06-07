package com.gsh.test;

import org.junit.Test;

import com.gsh.util.TimeStampGenerator;

public class TimeStampGeneratorTest
{
	@Test
	public void test()
	{
		TimeStampGenerator t = new TimeStampGenerator();
		System.out.println(t.getTimeStamp());
	}
}
