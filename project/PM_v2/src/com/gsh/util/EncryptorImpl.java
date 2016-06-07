package com.gsh.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptorImpl implements Encryptor
{

	@Override
	public byte[] encrypt(byte[] key, String text) throws Exception
	{
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		byte[] textByte = text.getBytes("utf-8");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		return cipher.doFinal(textByte);
	}

	@Override
	public String decrypt(byte[] key, byte[] cipherText) throws Exception
	{
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		return new String(cipher.doFinal(cipherText));
	}

	@Override
	public String base64Encode(byte[] data)
	{
		return Base64.getEncoder().encodeToString(data);
	}

	@Override
	public byte[] base64Decode(String str)
	{
		return Base64.getDecoder().decode(str);
	}

}
