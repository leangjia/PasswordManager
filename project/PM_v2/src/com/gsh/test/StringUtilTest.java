package com.gsh.test;

import org.junit.Test;

import com.gsh.util.StringUtil;

public class StringUtilTest
{
	@Test
	public void test()
	{
		String a = "啊啊啊asasaASASasASsaasSASAS";
		String b = "啊啊Ass";
		System.out.println(StringUtil.includeIngnoreCase(a, b));
	}
}
