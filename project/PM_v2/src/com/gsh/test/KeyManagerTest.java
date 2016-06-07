package com.gsh.test;

import java.io.File;

import org.junit.Test;

import com.gsh.util.KeyManager;
import com.gsh.util.KeyManagerImpl;

/**
 * 秘钥管理测试
 * @author gaoshuhang
 *
 */
public class KeyManagerTest
{
	@Test
	public void test()
	{
		File file = new File("/home/gaoshuhang/key");
		KeyManager km = new KeyManagerImpl();
		try
		{
			km.createKey(file);
			byte[] result = km.readKey(file);
			System.out.println(new String(result));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
