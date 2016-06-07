package com.gsh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyManagerImpl implements KeyManager
{

	@Override
	public void createKey(File keyFile) throws Exception
	{
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);
		SecretKey skey = kgen.generateKey();
		OutputStream out = new FileOutputStream(keyFile);
		out.write(skey.getEncoded());
		out.close();
	}

	@Override
	public byte[] readKey(File keyFile) throws Exception
	{
		InputStream in = new FileInputStream(keyFile);
		byte[] buff = new byte[16];
		in.read(buff);
		in.close();
		return buff;
	}

}
