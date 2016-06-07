package com.gsh.test;

import org.junit.Test;

import com.gsh.util.RandGenerator;
import com.gsh.util.RandGeneratorImpl;

/**
 * 随机密码生成器测试类
 * @author gaoshuhang
 *
 */
public class RandGeneratorTest
{
	@Test
	public void test()
	{
		String range = "abc";
		RandGenerator rg = new RandGeneratorImpl();
		String result = rg.randCreate(range, 20);
		System.out.println(result);
	}
}
