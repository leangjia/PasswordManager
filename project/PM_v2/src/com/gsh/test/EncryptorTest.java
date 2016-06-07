package com.gsh.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.gsh.util.Encryptor;
import com.gsh.util.EncryptorImpl;

public class EncryptorTest
{
	@Test
	public void test()
	{
		Encryptor enc = new EncryptorImpl();
		byte[] key = new byte[16];
		try
		{
			InputStream in = new FileInputStream("/home/gaoshuhang/key");
			in.read(key);
			String text = "test";
			System.out.println(text);
			byte[] cipher_byte = enc.encrypt(key, text);
			String cipher_str = enc.base64Encode(cipher_byte);
			System.out.println(cipher_str);
			cipher_byte = enc.base64Decode(cipher_str);
			text = enc.decrypt(key, cipher_byte);
			System.out.println(text);
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
